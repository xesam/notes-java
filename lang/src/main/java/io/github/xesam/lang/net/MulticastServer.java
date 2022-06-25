package io.github.xesam.lang.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

/**
 * Created by xe on 16-5-13.
 */
public class MulticastServer {

    public static final String HOST = "224.0.0.0";
    public static final int PORT = 8888;

    public static void main(String[] args) {
        MulticastServer multicastServer = new MulticastServer();
        multicastServer.start();
    }

    public void start() {
        System.out.println("Multicast Time Server");
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket();
            while (true) {
                String dateText = new Date().toString();
                byte[] buffer = dateText.getBytes();
                InetAddress group = InetAddress.getByName(HOST);
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);
                serverSocket.send(packet);
                System.out.println("Time sent:" + dateText);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    //	Handle	exception
                }
            }
        } catch (SocketException ex) {
            //	Handle	exception
        } catch (IOException ex) {
            //	Handle	exception
        }
    }

}
