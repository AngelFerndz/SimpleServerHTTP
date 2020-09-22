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
        requestCommand = new RequestCommand();
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
            case "help":
                helpCommand.run(command);
                break;
            default:
                Logger.log("'" + command + "' Not Found, type 'help' for available commands.");
        }

    }

}
