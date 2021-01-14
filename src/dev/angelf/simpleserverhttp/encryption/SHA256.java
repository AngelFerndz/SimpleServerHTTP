package dev.angelf.simpleserverhttp.encryption;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256 {

    public static String convert(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] sha256 = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return toHexString(sha256);
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    private static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

}
