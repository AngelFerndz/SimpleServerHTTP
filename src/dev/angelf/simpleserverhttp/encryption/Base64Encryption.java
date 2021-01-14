package dev.angelf.simpleserverhttp.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Encryption {
    public static final String DEFAULT_ENCODING = "UTF-8";
    private static BASE64Encoder enc = new BASE64Encoder();
    private static BASE64Decoder dec = new BASE64Decoder();

    public static String encrypt(String Text, String Key) {
        String result = xorMessage(Text, Key);
        return base64encode(result);
    }

    public static String decrypt(String Text, String Key) {
        String result = base64decode(Text);
        return xorMessage(result, Key);
    }

    private static String base64encode(String text) {
        try {
            return enc.encode(text.getBytes(DEFAULT_ENCODING));
        } catch (Exception e) {
            return null;
        }
    }

    private static String base64decode(String text) {
        try {
            return new String(dec.decodeBuffer(text), DEFAULT_ENCODING);
        } catch (Exception e) {
            return null;
        }
    }

    private static String xorMessage(String message, String key) {
        try {
            if (message == null || key == null) return null;

            char[] keys = key.toCharArray();
            char[] mesg = message.toCharArray();

            int ml = mesg.length;
            int kl = keys.length;
            char[] newmsg = new char[ml];

            for (int i = 0; i < ml; i++) {
                newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
            }

            return new String(newmsg);
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

}
