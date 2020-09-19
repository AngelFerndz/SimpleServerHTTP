package dev.angelf.simpleserverhttp.commands;

import java.util.Scanner;

public class CommandHandler {

    private static Scanner scanner;
    private boolean running;
    private HelpCommand helpCommand;

    public CommandHandler(){
        load();
    }

    public void start(){
        running = true;
        run();
    }

    private void run(){
        while (running) {
            String command = scanner.nextLine();
            process(command);
        }
    }

    private void load(){
        scanner = new Scanner(System.in);
        helpCommand = new HelpCommand();
    }

    private void process(String command) {
        String[] elements = command.toLowerCase().split(" ");

        try {
            switch (elements[0]) {
                case "start_server":
                    //startServer();
                    break;
                case "request":
                    //sendRequest(elements[1]);
                    break;
                case "stop_server":
                    //simpleServer.stop();
                    break;
                case "get_server_ip":
                    //System.out.println(simpleServer.getIP());
                    break;
                case "get_server_port":
                    //System.out.println(simpleServer.getPort());
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
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
