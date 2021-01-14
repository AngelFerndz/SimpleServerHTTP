package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.tools.Clipboard;
import dev.angelf.simpleserverhttp.tools.Logger;

import java.util.Scanner;

public class CommandHandler {

    private static Scanner scanner;
    private boolean running;

    // Commands
    private HelpCommand helpCommand;
    private ServerCommand serverCommand;
    private RequestCommand requestCommand;
    private ReadCommand readCommand;
    private OpenCommand openCommand;
    private SaveCommand saveCommand;

    public CommandHandler() {
        print_text();
        load();
    }

    public void start() {
        running = true;
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
        readCommand = new ReadCommand();
        openCommand = new OpenCommand();
        saveCommand = new SaveCommand();
    }

    private void print_text() {
        Logger.log("Simple HTTP Server");
        Logger.log("Created by Angel Fernandez");
        Logger.log("--------------------------");
        Logger.log("type 'help' to get started.");
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
                readCommand.run(command);
                break;
            case "open":
                openCommand.run(command);
                break;
            case "save":
                saveCommand.run(command);
                break;
            case "clipboard":
                Logger.log(Clipboard.get_data());
                break;
            case "help":
                helpCommand.run(command);
                break;
            default:
                Logger.log("'" + command + "' Not Found, type 'help' for available commands.");
        }

    }

}
