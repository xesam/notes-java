package dev.xesam.javalang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by xe on 14-11-24.
 */
public class SelectorTest {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("localhost", 80));

        System.out.println(selectionKey.isConnectable());
        System.out.println(socketChannel.isRegistered());

        selector.select();

        Inspector.inspect(selector.keys());
        Inspector.inspect(selector.selectedKeys());

        System.out.println("cancel");
        selectionKey.cancel();
        selector.selectNow();
        Inspector.inspect(selector.keys());
        Inspector.inspect(selector.selectedKeys());
    }

}
