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
                    start_server(elements);
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
                default:
                    Logger.log("Invalid Command");
                    break;
            }
        } else {
            boolean isActive = is_active();
            Logger.log("Server Active: " + isActive);
        }
    }

    private void start_server(String[] elements) {
        try {
            int amount = 1;
            SimpleServer.initialize();

            if (elements.length > 2) {
                // modify amount
                amount = Integer.parseInt(elements[2]);
            }

            SimpleServer.getInstance().start(amount);
        } catch (Exception e) {
            Logger.log("Error: " + e);
        }
    }

    private void stop_server() {
        if (is_active()) {
            SimpleServer.getInstance().stop();
        } else {
            Logger.log("Server not active!");
        }
    }

    private void get_ip() {
        if (is_active()) {
            String ip = SimpleServer.getInstance().get_ip();
            Logger.log("Server IP: " + ip);
        } else {
            Logger.log("Server not active!");
        }
    }

    private void get_port() {
        if (is_active()) {
            int port = SimpleServer.getInstance().get_port();
            Logger.log("Server Port: " + port);
        } else {
            Logger.log("Server not active!");
        }
    }

    private boolean is_active() {
        return SimpleServer.getInstance() != null;
    }

}
