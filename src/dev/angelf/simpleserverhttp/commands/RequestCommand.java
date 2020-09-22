package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.client.SimpleClient;

public class RequestCommand implements Command{
    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if(elements.length > 1) {
            String request = SimpleClient.request("127.0.0.1", "80", elements[1]);
            System.out.println(request);
        } else {
            System.out.println("Invalid Request, type 'help' for more information.");
        }
    }
}
