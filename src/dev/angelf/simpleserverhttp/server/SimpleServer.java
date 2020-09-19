package dev.angelf.simpleserverhttp.server;

import com.sun.net.httpserver.HttpServer;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SimpleServer {

    private String hostname;
    private int port;
    private HttpServer server;
    private static SimpleServer instance;

    // Singleton
    public static void initialize(){
        instance = new SimpleServer(8080, "localhost");
    }

    public static void initialize(int Port){
        instance = new SimpleServer(Port, "localhost");
    }

    public static void initialize(int Port, String HostName){
        instance = new SimpleServer(Port, HostName);
    }

    public static SimpleServer getInstance(){
        return instance;
    }

    // Constructor
    private SimpleServer(int Port, String HostName) {
        port = Port;
        hostname = HostName;
        System.out.println("Starting Server \nHost: " + HostName + " \nPort: " + Port);
    }

    // Methods
    public void start() {
        start(1);
    }

    public void start(int ThreadAmount) {
        try {
            server = HttpServer.create(new InetSocketAddress(hostname, port), 0);
            ThreadPoolExecutor threadPoolExecutor;
            threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(ThreadAmount);

            server.createContext("/", new RequestHandler());
            server.setExecutor(threadPoolExecutor);
            server.start();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void stop() {
        System.out.println("Stopping Server");
        server.stop(1);
    }

    public int getPort() {
        return port;
    }

    public String getIP() {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            return socket.getLocalAddress().getHostAddress();
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

}
