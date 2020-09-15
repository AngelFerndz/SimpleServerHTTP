package dev.angelf.simpleserverhttp;

import dev.angelf.simpleserverhttp.client.SimpleClient;
import dev.angelf.simpleserverhttp.server.SimpleServer;

public class Main {

    public static void main(String[] args) {
        startServer();
        startClient();
    }

    private static void startServer() {
        SimpleServer server = new SimpleServer(8001);
        server.start();
    }

    private static void startClient(){
        SimpleClient simpleClient = new SimpleClient();
        String response = simpleClient.request("127.0.0.1", "8001", "/ip_list.json");
        System.out.println(response);
    }

}