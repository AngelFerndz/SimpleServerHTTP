package dev.angelf.simpleserverhttp.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dev.angelf.simpleserverhttp.filesystem.ReadFile;

import java.io.IOException;
import java.io.OutputStream;

public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = get(httpExchange.getRequestURI().toString());
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }

    private String get(String File){
        System.out.println("Request: " +  File);
        return ReadFile.read("files" + File);
    }

}