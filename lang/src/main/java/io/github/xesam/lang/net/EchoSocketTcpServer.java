package io.github.xesam.lang.net;

import io.github.xesam.lang.tools.L;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xe on 11/20/15.
 */
public class EchoSocketTcpServer {

    public static void main(String[] args) {
        EchoSocketTcpServer echoSocketTcpServer = new EchoSocketTcpServer();
        echoSocketTcpServer.start();
    }

    public EchoSocketTcpServer() {

    }

    public void start() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(SocketConfig.ECHO_SERVER_HOST, SocketConfig.TCP_ECHO_SERVER_PORT);
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(inetSocketAddress);
            while (true) {
                L.log("listening:" + serverSocket);
                Socket socket = serverSocket.accept();
                L.log("connected from :" + socket.getRemoteSocketAddress());

                new Handler(serverSocket, socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Handler extends Thread {

        private ServerSocket serverSocket;
        private Socket clientSocket;

        public Handler(ServerSocket serverSocket, Socket clientSocket) {
            setName(String.valueOf(clientSocket.getRemoteSocketAddress()));
            this.serverSocket = serverSocket;
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = clientSocket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    L.log(getName(), "receive from:", line);
                    bufferedWriter.write(line);
                    bufferedWriter.write(SocketConfig.ECHO_CRLF);
                    bufferedWriter.flush();
                    L.log(getName(), "send back:", line);
                }
                L.log(getName(), "closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
