package dev.angelf.simpleserverhttp.filesystem;

import dev.angelf.simpleserverhttp.tools.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void write(String Text, String FilePath, String FileName) {
        try {
            FileWriter myWriter = new FileWriter(FilePath + "/" + FileName);
            myWriter.write(Text);
            myWriter.close();
            Logger.log("Wrote file [" + FileName + "] in [" + FilePath + "]");
        } catch (IOException e) {
            Logger.log("Error writing [" + FileName + "] in [" + FilePath + "]");
            Logger.log(e.getMessage());
        }
    }

    public static void write(String Text, String FileName) {
        try {
            FileWriter myWriter = new FileWriter(FileName);
            myWriter.write(Text);
            myWriter.close();
            Logger.log("Wrote file [" + FileName + "]");
        } catch (IOException e) {
            Logger.log("Error writing [" + FileName + "]");
            Logger.log(e.getMessage());
        }
    }

    public static void appendNewLine(String FilePath, String FileName, String Text){

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FilePath + "/" + FileName, true)  //Set true for append mode
            );
            writer.newLine();   //Add new line
            writer.write(Text);
            writer.close();
        } catch (Exception e){
            Logger.log("Error: " + e);
        }

    }

}
