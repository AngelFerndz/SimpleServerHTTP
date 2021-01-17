package dev.angelf.simpleserverhttp.client;

import dev.angelf.simpleserverhttp.tools.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class SimpleClient {

    public static String request(String IP, String Port, String Location) {
        try {
            String Address = "http://" + IP + ":" + Port + Location;
            URL url = new URL(Address);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            BufferedReader br;
            if (httpCon.getResponseCode() == 200 || httpCon.getResponseCode() == 400) {
                br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(httpCon.getErrorStream()));
            }

            String result = "";
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                result += strCurrentLine;
            }

            return result;
        } catch (Exception e) {
            sendPingRequest(IP);
            return ("Request Error: '" + Location + "' not found!");
        }
    }

    public static void sendPingRequest(String IP) {
        try {
            InetAddress geek = InetAddress.getByName(IP);
            Logger.log("Sending Ping Request to " + IP);
            if (geek.isReachable(5000)) {
                Logger.log("Host is reachable");

            } else {
                Logger.log("Cannot reach to this host");
            }
        } catch (Exception e) {
            Logger.log("Ping Error: " + e);
        }
    }

    public static int pingHost(String IP){
        try {
            Long start = System.currentTimeMillis();
            if (!InetAddress.getByName(IP).isReachable(2000)) return -1;
            return (int) (System.currentTimeMillis() - start);
        } catch (Exception e) {
            Logger.log("Error: " + e);
            return -1;
        }
    }

}
