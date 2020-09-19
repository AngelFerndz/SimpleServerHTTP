package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.server.SimpleServer;

public class ServerCommand implements Command{

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if(elements.length > 1) {
            switch (elements[1]) {
                case "start":
                    SimpleServer.initialize();
                    SimpleServer.getInstance().start();
                    System.out.println("Server Running");
                    break;
                case "stop":
                    SimpleServer.getInstance().stop();
                    System.out.println("Server Stopped");
                    break;
                case "ip":
                    String ip = SimpleServer.getInstance().getIP();
                    System.out.println(ip);
                    break;
                case "port":
                    int port = SimpleServer.getInstance().getPort();
                    System.out.println(port);
                    break;
            }
        } else {
            boolean isActive = SimpleServer.getInstance() != null;
            System.out.println("Server Active: " + isActive);
        }
    }

}
