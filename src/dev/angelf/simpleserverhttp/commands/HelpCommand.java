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
                "----------------------------------------------- Help Menu \n" +
                        "server              : type 'help server' for more info \n" +
                        "request [IP] [file] : send a request as a client \n" +
                        "read [file]         : read file in the 'file' directory \n" +
                        "open [file]         : stores file data in clipboard \n" +
                        "save [file]        : save clipboard to file \n" +
                        "clipboard           : display clipboard data. \n" +
                        "stop                : ends program \n" +
                        "help                : opens this screen \n" +
                        "help [command]      : get more information on command \n" +
                        "---------------------------------------------------------");
    }

    private void help(String element) {
        switch (element) {
            case "server":
                System.out.println("server [command]");
                System.out.println("server ip    : get local ip address");
                System.out.println("server port  : get port");
                System.out.println("server start : start default server");
                System.out.println("server stop  : stop current server instance");
                System.out.println("server       : server active");
                break;
            case "request":
                System.out.println("request [IP] [file]");
                System.out.println("Example: index.html");
                break;
            case "read":
                System.out.println("read [file]");
                System.out.println("Example: read index.html");
                break;
            case "save":
                System.out.println("save [file]");
                System.out.println("saves data stored in clipboard to a file.");
                break;
            case "open":
                System.out.println("open [file]");
                System.out.println("opens stores data from a file to clipboard.");
                break;
            case "clipboard":
                System.out.println("clipboard");
                System.out.println("clipboard contains data as a String value.");
        }
    }

}
