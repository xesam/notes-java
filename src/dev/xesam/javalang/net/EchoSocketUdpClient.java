package dev.xesam.javalang.net;

import dev.xesam.javalang.tools.L;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Created by xe on 14-11-24.
 */
public class EchoSocketUdpClient {

    public static void main(String[] args) {
        EchoSocketUdpClient echoSocketTcpClient = new EchoSocketUdpClient();
        echoSocketTcpClient.requestEcho();
    }

    public void requestEcho() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(SocketConfig.ECHO_SERVER_HOST, SocketConfig.UDP_ECHO_SERVER_PORT);
        try {

            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.setSoTimeout(3 * 1000);

            String send = "hello,xesam";
            DatagramPacket sendPacket = new DatagramPacket(send.getBytes(), send.getBytes().length, inetSocketAddress);
            L.log("send:" + send);
            datagramSocket.send(sendPacket);

            byte[] bytes = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(receivePacket);

            L.log("receive:" + new String(bytes));
            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
