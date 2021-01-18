package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.client.SimpleClient;
import dev.angelf.simpleserverhttp.tools.Logger;

public class PingCommand implements Command{

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 1) {
            int ms = SimpleClient.pingHost(elements[1]);
            Logger.log("Ping " + elements[1] + " : " + ms + "ms");
        } else {
            Logger.log("Invalid Request '" + command + "', type 'help' for more information.");
        }
    }
}
