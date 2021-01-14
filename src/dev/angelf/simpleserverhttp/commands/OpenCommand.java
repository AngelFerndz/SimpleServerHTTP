package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.filesystem.ReadFile;
import dev.angelf.simpleserverhttp.tools.Clipboard;
import dev.angelf.simpleserverhttp.tools.Logger;

public class OpenCommand implements Command {

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 1) {
            open(elements[1]);
        } else {
            Logger.log("Specify what file to read.");
        }
    }

    private void open(String FileName) {
        String filePath = "file/" + FileName;
        String file = ReadFile.read(filePath);
        Logger.log(file);
        Clipboard.set_data(file);
    }

}
