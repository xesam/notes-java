package io.github.xesam.lang.nio;

import java.io.IOException;
import java.nio.channels.NetworkChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by xe on 15-2-13.
 */
public class NetworkChannelTest {
    public static void main(String[] args) {
        try {
            NetworkChannel networkChannel = SocketChannel.open();
            networkChannel.supportedOptions().stream().forEach((item) -> {
                System.out.println(item);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
