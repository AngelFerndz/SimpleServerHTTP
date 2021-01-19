package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.network.SimpleServer;
import dev.angelf.simpleserverhttp.tools.Logger;

public class ServerCommand implements Command {

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 1) {
            switch (elements[1]) {
                case "start":
                    start_server();
                    break;
                case "stop":
                    stop_server();
                    break;
                case "ip":
                    get_ip();
                    break;
                case "port":
                    get_port();
                    break;
            }
        } else {
            boolean isActive = SimpleServer.getInstance() != null;
            Logger.log("Server Active: " + isActive);
        }
    }

    private void start_server() {
        try {
            SimpleServer.initialize();
            SimpleServer.getInstance().start();
        } catch (Exception e) {
            Logger.log("Error: " + e);
        }
    }

    private void stop_server() {
        try {
            SimpleServer.getInstance().stop();
        } catch (Exception e) {
            Logger.log("Error: " + e);
        }
    }

    private void get_ip() {
        try {
            String ip = SimpleServer.getInstance().get_ip();
            Logger.log("Server IP: " + ip);
        } catch (Exception e) {
            Logger.log("Error: " + e);
        }
    }

    private void get_port() {
        try {
            int port = SimpleServer.getInstance().get_port();
            Logger.log("Server Port: " + port);
        } catch (Exception e) {
            Logger.log("Error: " + e);
        }
    }

}
