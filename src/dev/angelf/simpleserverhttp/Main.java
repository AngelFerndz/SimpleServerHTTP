package dev.angelf.simpleserverhttp;

import dev.angelf.simpleserverhttp.client.SimpleClient;
import dev.angelf.simpleserverhttp.server.SimpleServer;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        process("help");
        while (true) {
            String command = scanner.nextLine();
            process(command);
        }
    }

    private static void process(String command){
        String[] elements = command.toLowerCase().split(" ");

        switch (elements[0]) {
            case "startserver":
                startServer();
                break;
            case "startclient":
                startClient();
                break;
            case "close":
                System.exit(-1);
                break;
            case "help":
                System.out.println(
                        "startserver : start a server in port 8001\n" +
                        "startclient : start a client and run a test request\n" +
                        "close       : close program\n" +
                        "help        : to open this screen");
                break;
            default:
                System.out.println("Command Not Found, type 'help' for available commands.");
        }
    }

    private static void startServer() {
        SimpleServer server = new SimpleServer(8001);
        server.start();
    }

    private static void startClient(){
        SimpleClient simpleClient = new SimpleClient();
        String response = simpleClient.request("127.0.0.1", "8001", "/ip_list.json");
        System.out.println(response);
    }

}