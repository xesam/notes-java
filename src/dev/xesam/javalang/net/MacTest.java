package dev.xesam.javalang.net;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Created by xe on 16-5-16.
 */
public class MacTest {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            Collections.list(networkInterfaces)
                    .stream()
                    .forEach(networkInterface -> {
                        try {
                            System.out.println(networkInterface.getName());
                            byte[] bytes = networkInterface.getHardwareAddress();
                            if (bytes == null) {
                                return;
                            }
                            for (int i = 0; i < bytes.length; i++) {
                                System.out.print(String.format("%02x", bytes[i]));
                            }
                            System.out.println("");

                        } catch (SocketException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
