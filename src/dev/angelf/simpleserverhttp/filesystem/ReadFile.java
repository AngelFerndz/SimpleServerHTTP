package dev.angelf.simpleserverhttp.filesystem;

import dev.angelf.simpleserverhttp.tools.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static String read(String FilePath) {
        String Text = "";

        try {
            File file = new File(FilePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Text += data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            return "Error " + e;
        }

        return Text;
    }

}
