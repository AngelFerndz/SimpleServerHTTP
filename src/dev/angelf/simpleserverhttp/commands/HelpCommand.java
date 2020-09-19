package dev.angelf.simpleserverhttp.commands;

public class HelpCommand implements Command {

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 1) {
            switch (elements[1]) {
                // add command variants
                case "request":
                    System.out.println("request [request]");
                    break;
            }
        } else {
            full();
        }
    }

    private void full() {
        System.out.println(
                "----------------------------------------------- Help Menu\n" +
                        "start_server      : start a server in port 8080\n" +
                        "stop_server       : stop the server\n" +
                        "get_server_ip     : get the current server IP\n" +
                        "get_server_port   : get the current server port\n" +
                        "request [Request] : send a request as a client\n" +
                        "close             : close program\n" +
                        "help              : to open this screen\n" +
                        "---------------------------------------------------------");
    }

}
