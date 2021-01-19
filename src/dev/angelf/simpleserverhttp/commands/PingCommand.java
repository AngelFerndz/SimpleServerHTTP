package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.network.SimpleClient;
import dev.angelf.simpleserverhttp.filesystem.ReadFile;
import dev.angelf.simpleserverhttp.tools.Logger;

public class PingCommand implements Command{

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");

        if (elements.length > 1) {
            process(elements[1]);
        } else {
            Logger.log("Invalid Request '" + command + "', type 'help' for more information.");
        }
    }

    private void process(String command) {
        if (command.equals("all")) {
            //TODO ping all in ip_list
            String file = ReadFile.read("file/ip_list");
            String[] list = file.split(",");
            for (String s : list) {
                ping(s);
            }
        } else {
            ping(command);
        }
    }

    private void ping(String IP){
        int ms = SimpleClient.ping_host(IP);
        Logger.log("Ping " + IP + " : " + ms + "ms");
    }

}
