package dev.xesam.javalang.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by xe on 16-4-15.
 */
public class InetAddressTest {

    public static void main(String[] args) {
        testNetworkInterface();
    }

    public static void testNetworkInterface() {

        try {
            Enumeration<NetworkInterface> elements = NetworkInterface.getNetworkInterfaces();
            while (elements.hasMoreElements()) {
                NetworkInterface networkInterface = elements.nextElement();
                inspect(networkInterface);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void inspect(NetworkInterface networkInterface) throws SocketException {
        System.out.println("----------------------");
        System.out.println(networkInterface.toString());
        Enumeration<InetAddress> elements = networkInterface.getInetAddresses();
        while (elements.hasMoreElements()) {
            InetAddress inetAddress = elements.nextElement();
            System.out.println(inetAddress);
        }
    }
}
