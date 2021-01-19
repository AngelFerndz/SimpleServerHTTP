package dev.angelf.simpleserverhttp.network;

import dev.angelf.simpleserverhttp.tools.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
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
            send_ping_request(IP);
            return ("Request Error: '" + Location + "' not found!");
        }
    }

    public static void send_ping_request(String IP) {
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

    public static int ping_host(String IP) {
        try {
            Long start = System.currentTimeMillis();
            if (!InetAddress.getByName(IP).isReachable(2000)) return -1;
            return (int) (System.currentTimeMillis() - start);
        } catch (Exception e) {
            Logger.log("Error: " + e);
            return -1;
        }
    }

    public static String get_public_ip() {
        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String ip = in.readLine(); //you get the IP as a String
            return ip;
        } catch (Exception e) {
            Logger.log("Error :" + e);
            return "";
        }
    }

    public static String get_ip() {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 80);
            return socket.getLocalAddress().getHostAddress();
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

}
