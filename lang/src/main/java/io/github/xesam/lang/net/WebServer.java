package io.github.xesam.lang.net;

import io.github.xesam.lang.tools.L;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * Created by xe on 16-5-23.
 */
public class WebServer {

    public static final String SERVER_HOST = "127.0.0.1";
    public static final int SERVER_PORT = 10001;
    public static final String CRLF = "\r\n";

    public static void main(String[] args) {
        new WebServer().start();
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
            L.log("listening:" + serverSocket.getInetAddress());
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new RequestHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class RequestHandler implements Runnable {

        private Socket socket;

        public RequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            L.log("connected from :" + socket.getRemoteSocketAddress());
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = bufferedReader.readLine();
                System.out.println(line);
                StringTokenizer tokenizer = new StringTokenizer(line);
                String method = tokenizer.nextToken();
                if (method.equalsIgnoreCase("get")) {
                    System.out.println("Get	method processed");
                    String httpQueryString = tokenizer.nextToken();
                    StringBuilder responseBuffer = new StringBuilder()
                            .append("<html><h1>WebServer Home Page....	</h1><br>")
                            .append("<b>Welcome	to	my	web	server!</b><BR>")
                            .append("</html>");
                    sendResponse(200, responseBuffer.toString());
                } else {
                    System.out.println("The	HTTP method	is	not	recognized");
                    sendResponse(405, "Method Not Allowed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendResponse(int statusCode, String responseString) throws IOException {
            String statusLine;
            String serverHeader = "Server:WebServer" + CRLF;
            String contentTypeHeader = "Content-Type:text/html" + CRLF;
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            if (statusCode == 200) {
                statusLine = "HTTP/1.0 200 OK" + CRLF;
                String contentLengthHeader = "Content-Length:" + responseString.length() + CRLF;
                bufferedWriter.write(statusLine);
                bufferedWriter.write(serverHeader);
                bufferedWriter.write(contentTypeHeader);
                bufferedWriter.write(contentLengthHeader);
                bufferedWriter.write(CRLF);
                bufferedWriter.write(responseString);
            } else if (statusCode == 405) {
                statusLine = "HTTP/1.0	405	Method	Not	Allowed" + CRLF;
                bufferedWriter.write(statusLine);
                bufferedWriter.write(CRLF);
            } else {
                statusLine = "HTTP/1.0	404	Not	Found" + CRLF;
                bufferedWriter.write(statusLine);
                bufferedWriter.write(CRLF);
            }
            bufferedWriter.close();
        }
    }
}
