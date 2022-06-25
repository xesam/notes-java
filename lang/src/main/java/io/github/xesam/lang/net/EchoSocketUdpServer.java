package io.github.xesam.lang.net;

import io.github.xesam.lang.tools.L;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

/**
 * Created by xe on 11/20/15.
 */
public class EchoSocketUdpServer {

    public static void main(String[] args) {
        EchoSocketUdpServer echoSocketUdpServer = new EchoSocketUdpServer();
        echoSocketUdpServer.start();
    }

    public EchoSocketUdpServer() {

    }

    public void start() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(SocketConfig.ECHO_SERVER_HOST, SocketConfig.UDP_ECHO_SERVER_PORT);
        try {
            DatagramSocket datagramSocket = new DatagramSocket(null);
            datagramSocket.bind(inetSocketAddress);
            byte[] bytes = new byte[1024];
            while (true) {
                L.log("listening:" + inetSocketAddress);
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(packet);
                L.log(new String(packet.getData(), Charset.defaultCharset().name()));

                packet.setAddress(packet.getAddress());
                datagramSocket.send(packet);
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
                    L.log(getName(), "receive:", line);
                    bufferedWriter.write(line);
                    bufferedWriter.write(SocketConfig.ECHO_CRLF);
                    bufferedWriter.flush();
                    L.log(getName(), "send:", line);
                }
                L.log(getName(), "closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
