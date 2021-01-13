package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.filesystem.ReadFile;
import dev.angelf.simpleserverhttp.tools.Logger;

public class ReadCommand implements Command {

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 1) {
            read(elements[1]);
        } else {
            Logger.log("Specify what file to read.");
        }
    }

    private void read(String FileName) {
        String filePath = "file/" + FileName;
        Logger.log(ReadFile.read(filePath));
    }

}
