package dev.angelf.simpleserverhttp.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class SimpleClient {

    public String request(String IP, String Port, String Location) {
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
            String ping = sendPingRequest(IP);
            return ("Request Error: " + e + " | " + ping);
        }
    }

    public String sendPingRequest(String IP) {
        try {
            InetAddress geek = InetAddress.getByName(IP);
            System.out.println("Sending Ping Request to " + IP);
            if (geek.isReachable(5000)) {
                return "Host is reachable";
            } else {
                return "Cannot reach to this host";
            }
        } catch (Exception e) {
            return "Ping Error: " + e;
        }
    }

}