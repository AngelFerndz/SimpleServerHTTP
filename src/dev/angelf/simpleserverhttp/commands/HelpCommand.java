package dev.angelf.simpleserverhttp.commands;

public class HelpCommand implements Command {

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 1) {
            help(elements[1]);
        } else {
            full();
        }
    }

    private void full() {
        System.out.println(
                "----------------------------------------------- Help Menu\n" +
                        "server []         : \n" +
                        "request []        : send a request as a client\n" +
                        "end               : end program\n" +
                        "help              : to open this screen\n" +
                        "help [command]    : get more information on command" +
                        "---------------------------------------------------------");
    }

    private void help(String element){
        switch (element){
            case "request":
                System.out.println("request [URL]");
                System.out.println("Example: request /test");
                break;
            case "server":
                System.out.println("server [command]");
                System.out.println("server ip    : get local ip address");
                System.out.println("server port  : get port");
                System.out.println("server start : start default server");
                System.out.println("server stop  : stop current server instance");
                System.out.println("server       : server active");
                break;
        }
    }

}
