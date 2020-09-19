package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.server.SimpleServer;

import java.util.Scanner;

public class CommandHandler {

    private static Scanner scanner;
    private boolean running;

    // Commands
    private HelpCommand helpCommand;

    public CommandHandler() {
        load();
    }

    public void start() {
        running = true;
        run();
    }

    private void run() {
        while (running) {
            String command = scanner.nextLine();
            process(command);
        }
    }

    private void load() {
        scanner = new Scanner(System.in);
        helpCommand = new HelpCommand();
    }

    private void process(String command) {
        String[] elements = command.toLowerCase().split(" ");

        switch (elements[0]) {
            case "start_server":
                SimpleServer.initialize();
                SimpleServer.getInstance().start();
                break;
            case "request":
                //sendRequest(elements[1]);
                break;
            case "stop_server":
                SimpleServer.getInstance().stop();
                break;
            case "get_server_ip":
                String ip = SimpleServer.getInstance().getIP();
                System.out.println(ip);
                break;
            case "get_server_port":
                int port = SimpleServer.getInstance().getPort();
                System.out.println(port);
                break;
            case "close":
                running = false;
                break;
            case "help":
                helpCommand.run(command);
                break;
            default:
                System.out.println("Command Not Found, type 'help' for available commands.");
        }

    }

}
