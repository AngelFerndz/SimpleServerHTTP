package dev.angelf.simpleserverhttp;

import dev.angelf.simpleserverhttp.commands.CommandHandler;

public class Main {

    public static void main(String[] args) {
        CommandHandler commandHandler;
        commandHandler = new CommandHandler();
        commandHandler.start();
    }

}