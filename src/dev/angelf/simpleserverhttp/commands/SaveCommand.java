package dev.angelf.simpleserverhttp.commands;

import dev.angelf.simpleserverhttp.filesystem.WriteFile;
import dev.angelf.simpleserverhttp.tools.Clipboard;
import dev.angelf.simpleserverhttp.tools.Logger;

public class SaveCommand implements Command {

    @Override
    public void run(String command) {
        String[] elements = command.split(" ");
        if (elements.length > 1) {
            save(elements[1]);
        } else {
            Logger.log("Specify what file to read.");
        }
    }

    private void save(String FileName){
        String filePath = "file/" + FileName;
        WriteFile.write(Clipboard.get_data(), filePath);
    }
}
