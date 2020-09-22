package dev.angelf.simpleserverhttp.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dev.angelf.simpleserverhttp.filesystem.ReadFile;
import dev.angelf.simpleserverhttp.tools.Logger;

import java.io.IOException;
import java.io.OutputStream;

public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String request = httpExchange.getRequestURI().toString();
        Logger.log("Request: " + request);
        String response = process(request);
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }

    private String process(String request) {
        String[] command = request.toLowerCase().split("/");

        switch (command[1]) {
            case "file": return get(command[2]);
            case "test": return "Test Works";
        }
        return "Invalid Request Error";
    }

    private String get(String File) {
        return ReadFile.read("file/" + File);
    }

}