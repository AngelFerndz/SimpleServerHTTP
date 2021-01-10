package dev.angelf.simpleserverhttp.tools;

public class Clipboard {

    private static String data;

    public static void set_data(String Data){
        data = Data;
    }

    public static String get_data() {
        return data;
    }

}
