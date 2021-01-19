package dev.angelf.simpleserverhttp.network;

import com.sun.net.httpserver.HttpServer;
import dev.angelf.simpleserverhttp.tools.Logger;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SimpleServer {

    private static HttpServer server;
    private static SimpleServer instance;
    private String hostname;
    private int port;

    // Constructor
    private SimpleServer(int Port, String HostName) {
        port = Port;
        hostname = HostName;
        Logger.log("Starting Server | Host: " + HostName + " | Port: " + Port);
    }

    // Singleton
    public static void initialize() {
        instance = new SimpleServer(80, "localhost");
    }

    public static void initialize(int Port) {
        instance = new SimpleServer(Port, "localhost");
    }

    public static void initialize(int Port, String HostName) {
        instance = new SimpleServer(Port, HostName);
    }

    public static SimpleServer getInstance() {
        return instance;
    }

    // Methods
    public void start() {
        if (server != null) {
            Logger.log("Server already active");
        } else {
            Logger.log("--------------------");
            start(1);
        }
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
            Logger.log("Error: " + e);
        }
    }

    public void stop() {
        Logger.log("Stopping Server");
        server.stop(1);
        server = null;
        Logger.log("Server Stopped");
    }

    public int get_port() {
        return port;
    }

    public String get_ip() {
        return SimpleClient.get_ip();
    }

}
