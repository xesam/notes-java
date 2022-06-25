package io.github.xesam.lang.net;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Set;

/**
 * Created by xe on 16-5-31.
 */
public class MyHTTPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("MyHTTPServer	Started");
        HttpServer server = HttpServer.create(new InetSocketAddress(9999), 0);
        server.createContext("/index", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                System.out.println(httpExchange.getRemoteAddress());

                Headers requestHeaders = httpExchange.getRequestHeaders();
                Set<String> keySet = requestHeaders.keySet();
                for (String key : keySet) {
                    List values = requestHeaders.get(key);
                    String header = key + "	= " + values.toString() + "\n";
                    System.out.print(header);
                }

                String response = getResponse();
                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream out = httpExchange.getResponseBody();
                out.write(response.toString().getBytes());
                out.close();
            }

            public String getResponse() {
                return "<html><body><h1>HTTPServer Home Page....</h1></body></html>";
            }
        });
        server.start();
    }
}
