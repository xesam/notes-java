package io.github.xesam.lang.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by xe on 16-5-13.
 */
public class MulticastClient {
    public static void main(String[] args) {
        MulticastClient multicastClient = new MulticastClient();
        multicastClient.listen();
    }

    public void listen() {
        System.out.println("Multicast Time Client");
        try (MulticastSocket socket = new MulticastSocket(MulticastServer.PORT)) {
            InetAddress group = InetAddress.getByName(MulticastServer.HOST);
            socket.joinGroup(group);
            System.out.println("Multicast Group	Joined");
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            for (int i = 0; i < 5; i++) {
                socket.receive(packet);
                String received = new String(packet.getData());
                //ThE trim method	removes	leading	and	trailing	white	space,	from	a	string.	Otherwise,	all 256	bytes	of	the	message	will	be	displayed
                System.out.println(received.trim());
            }

            socket.leaveGroup(group);
        } catch (IOException ex) {
            //	Handle	exception
        }
        System.out.println("Multicast		Time	Client	Terminated");
    }

}
