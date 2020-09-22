package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.server.SimpleServer;
import dev.angelf.simpleserverhttp.tools.Logger;

public class ServerCommand implements Command{

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if(elements.length > 1) {
            switch (elements[1]) {
                case "start":
                    SimpleServer.initialize();
                    SimpleServer.getInstance().start();
                    Logger.log("Server Running");
                    break;
                case "stop":
                    SimpleServer.getInstance().stop();
                    Logger.log("Server Stopped");
                    break;
                case "ip":
                    String ip = SimpleServer.getInstance().getIP();
                    Logger.log("Server IP: " + ip);
                    break;
                case "port":
                    int port = SimpleServer.getInstance().getPort();
                    Logger.log("Server Port: " + port);
                    break;
            }
        } else {
            boolean isActive = SimpleServer.getInstance() != null;
            Logger.log("Server Active: " + isActive);
        }
    }

}
