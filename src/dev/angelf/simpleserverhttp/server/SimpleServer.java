package dev.angelf.simpleserverhttp.server;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SimpleServer {

    private String hostname;
    private int port;
    private HttpServer server;

    // Constructors

    public SimpleServer() {
        port = 8080;
        hostname = "localhost";
    }

    public SimpleServer(int Port) {
        port = Port;
        hostname = "localhost";
    }

    public SimpleServer(int Port, String HostName){
        port = Port;
        hostname = HostName;
    }

    // Methods

    public void start(){
        start(1);
    }

    public void start(int ThreadAmount){
        try {
            server = HttpServer.create(new InetSocketAddress(hostname, port), 0);
            ThreadPoolExecutor threadPoolExecutor;
            threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(ThreadAmount);

            server.createContext("/", new RequestHandler());
            server.setExecutor(threadPoolExecutor);
            server.start();

        } catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public int getPort() {
        return port;
    }

}
