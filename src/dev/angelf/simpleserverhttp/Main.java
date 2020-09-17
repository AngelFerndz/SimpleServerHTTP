package dev.angelf.simpleserverhttp;

import dev.angelf.simpleserverhttp.client.SimpleClient;
import dev.angelf.simpleserverhttp.server.SimpleServer;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static SimpleServer simpleServer;
    private static SimpleClient simpleClient;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        process("help");
        while (true) {
            String command = scanner.nextLine();
            process(command);
        }
    }

    private static void process(String command) {
        String[] elements = command.toLowerCase().split(" ");

        switch (elements[0]) {
            case "start_server":
                startServer();
                break;
            case "start_client":
                startClient();
                break;
            case "stop_server":
                simpleServer.stop();
                break;
            case "get_server_ip":
                System.out.println(simpleServer.getIP());
                break;
            case "get_server_port":
                System.out.println(simpleServer.getPort());
                break;
            case "close":
                System.exit(-1);
                break;
            case "help":
                System.out.println(
                        "----------------------------------------------- Help Menu\n" +
                        "start_server    : start a server in port 8001\n" +
                        "stop_server     : stop the server\n" +
                        "get_server_ip   : get the current server IP\n" +
                        "get_server_port : get the current server port\n" +
                        "start_client    : start a client and run a test request\n" +
                        "close           : close program\n" +
                        "help            : to open this screen\n" +
                        "---------------------------------------------------------");
                break;
            default:
                System.out.println("Command Not Found, type 'help' for available commands.");
        }
    }

    private static void startServer() {
        simpleServer = new SimpleServer();
        simpleServer.start();
    }

    private static void startClient() {
        simpleClient = new SimpleClient();
        String response = simpleClient.request("127.0.0.1", "8001", "/ip_list.json");
        System.out.println(response);
    }

}