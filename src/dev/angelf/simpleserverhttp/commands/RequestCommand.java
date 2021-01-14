package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.client.SimpleClient;
import dev.angelf.simpleserverhttp.tools.Logger;

public class RequestCommand implements Command {
    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 1) {
            String request = SimpleClient.request("127.0.0.1", "80", elements[1]);
            Logger.log(request);
        } else {
            Logger.log("Invalid Request '" + command + "', type 'help' for more information.");
        }
    }
}
