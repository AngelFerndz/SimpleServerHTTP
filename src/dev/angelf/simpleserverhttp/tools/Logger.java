package dev.angelf.simpleserverhttp.tools;

import dev.angelf.simpleserverhttp.filesystem.WriteFile;

public class Logger {

    public static void log(String Text){
        String datetime = DateGenerator.getDateTime();
        String fileName = "log.txt";
        String log = datetime + " | " + Text;

        System.out.println(log);
        WriteFile.appendNewLine("log/",fileName, log);
    }

}
