package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.tools.Logger;

import java.util.Scanner;

public class CommandHandler {

    private static Scanner scanner;
    private boolean running;

    // Commands
    private HelpCommand helpCommand;
    private ServerCommand serverCommand;
    private RequestCommand requestCommand;
    private ReadFileCommand readFileCommand;

    public CommandHandler() {
        load();
    }

    public void start() {
        running = true;
        print_text();
        while (running) {
            String command = scanner.nextLine();
            process(command);
        }
    }

    private void load() {
        scanner = new Scanner(System.in);
        helpCommand = new HelpCommand();
        serverCommand = new ServerCommand();
        requestCommand = new RequestCommand();
        readFileCommand = new ReadFileCommand();
    }

    private void process(String command) {
        String[] elements = command.toLowerCase().split(" ");

        switch (elements[0]) {
            case "server":
                serverCommand.run(command);
                break;
            case "request":
                requestCommand.run(command);
                break;
            case "stop":
                running = false;
                System.exit(0);
                break;
            case "read":
                readFileCommand.run(command);
                break;
            case "help":
                helpCommand.run(command);
                break;
            default:
                Logger.log("'" + command + "' Not Found, type 'help' for available commands.");
        }

    }

    private void print_text() {
        Logger.log("Simple HTTP Server");
        Logger.log("Created by Angel Fernandez");
        Logger.log("--------------------------");
        Logger.log("type 'help' to get started.");
    }

}
