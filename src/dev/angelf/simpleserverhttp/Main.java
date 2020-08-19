package dev.angelf.simpleserverhttp;

import dev.angelf.simpleserverhttp.server.SimpleServer;

public class Main {

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        SimpleServer server = new SimpleServer(8001);
        server.start();
    }

}
