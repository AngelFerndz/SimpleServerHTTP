package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.network.SimpleClient;
import dev.angelf.simpleserverhttp.network.SimpleServer;
import dev.angelf.simpleserverhttp.tools.Logger;

public class StatusCommand implements Command {

    @Override
    public void run(String command) {
        ip_status();
        server_status();
    }

    private void ip_status() {
        String public_ip = SimpleClient.get_public_ip();
        Logger.log("Public IP     : " + public_ip);
        String ip = SimpleClient.get_ip();
        Logger.log("Local IP      : " + ip);
    }

    private void server_status() {
        boolean isActive = SimpleServer.getInstance() != null;
        Logger.log("Server Active : " + isActive);
    }

}
