package io.github.xesam.lang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xe on 15-3-28.
 */
public class NioNonBlockingEchoServer {

    public static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        new NonBlockingEchoServer().start();
    }

    public static class NonBlockingEchoServer {
        public void start() {
            try (Selector selector = Selector.open(); ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
                if (selector.isOpen() && serverSocketChannel.isOpen()) {
                    serverSocketChannel.configureBlocking(false);
                    serverSocketChannel.bind(new InetSocketAddress(SERVER_PORT));
                    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                    System.out.println("waiting for connect on: " + SERVER_PORT);
                    while (true) {
                        int count = selector.select();
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey selectionKey = iterator.next();
                            iterator.remove();
                            if (!selectionKey.isValid()) {
                                continue;
                            }
                            if (selectionKey.isAcceptable()) {
                                acceptOP(selectionKey, selector);
                            } else if (selectionKey.isReadable()) {
                                readOP(selectionKey, selector);
                            } else if (selectionKey.isWritable()) {
                                writeOP(selectionKey, selector);
                            }
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void acceptOP(SelectionKey key, Selector selector) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                System.out.println("[accept]" + socketChannel.getRemoteAddress());
                socketChannel.write(ByteBuffer.wrap("acceptOP hello!".getBytes()));
                socketChannel.register(selector, SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void readOP(SelectionKey key, Selector selector) throws IOException {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            try {
                System.out.println("[read]" + socketChannel.getRemoteAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(2);
            Charset charset = Charset.defaultCharset();

            int count;
            try {
                count = socketChannel.read(byteBuffer);
            } catch (IOException e) {
                key.channel().close();
                key.cancel();
                return;
            }

            if (count == -1) {
                key.channel().close();
                key.cancel();
                return;
            }

            byteBuffer.flip();
            System.out.println("[read]" + charset.decode(byteBuffer));
        }

        void writeOP(SelectionKey key, Selector selector) {
            System.out.println("writeOP");
            SocketChannel channel = (SocketChannel) key.channel();
            try {
                channel.write(ByteBuffer.wrap("writeOP".getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            key.interestOps(SelectionKey.OP_READ); //clear OP_WRITE
        }
    }
}
