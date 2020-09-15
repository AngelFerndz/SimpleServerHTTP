package dev.angelf.simpleserverhttp.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dev.angelf.simpleserverhttp.filesystem.ReadFile;

import java.io.IOException;
import java.io.OutputStream;

public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String request = httpExchange.getRequestURI().toString();
        System.out.println("Request: " + request);
        String fileContent = get(request);
        httpExchange.sendResponseHeaders(200, fileContent.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(fileContent.getBytes());
        outputStream.close();
    }

    private String get(String File){
        return ReadFile.read("files" + File);
    }

}