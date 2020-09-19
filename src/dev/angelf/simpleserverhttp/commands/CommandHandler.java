package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.server.SimpleServer;

import java.util.Scanner;

public class CommandHandler {

    private static Scanner scanner;
    private boolean running;

    // Commands
    private HelpCommand helpCommand;
    private ServerCommand serverCommand;

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
        serverCommand = new ServerCommand();
    }

    private void process(String command) {
        String[] elements = command.toLowerCase().split(" ");

        switch (elements[0]) {
            case "server":
                serverCommand.run(command);
                break;
            case "request":
                //sendRequest(elements[1]);
                break;
            case "end":
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
