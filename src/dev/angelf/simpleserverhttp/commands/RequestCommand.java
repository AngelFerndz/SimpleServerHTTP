package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.client.SimpleClient;
import dev.angelf.simpleserverhttp.tools.Logger;

public class RequestCommand implements Command {
    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 2) {
            try {
                String request = SimpleClient.request(elements[1], "80", elements[2]);
                Logger.log(request);
            } catch (Exception e) {
                Logger.log("Error: " + e);
            }
        } else {
            Logger.log("Invalid Request '" + command + "', type 'help' for more information.");
        }
    }
}
