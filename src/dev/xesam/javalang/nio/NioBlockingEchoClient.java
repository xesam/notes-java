package dev.xesam.javalang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.stream.IntStream;

/**
 * Created by xe on 15-3-28.
 */
public class NioBlockingEchoClient {
    public static void main(String[] args) {
        IntStream.range(0, 3).forEach((i) -> {
            new BlockingEchoClient().start();
        });

    }

    public static class BlockingEchoClient {
        public void start() {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(true);
                socketChannel.connect(new InetSocketAddress("localhost", NioNonBlockingEchoServer.SERVER_PORT));
                Charset charset = Charset.defaultCharset();
                if (socketChannel.isConnected()) {

                    StringBuilder sb = new StringBuilder();

                    socketChannel.write(ByteBuffer.wrap("0123456789".getBytes()));
//                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                    int count;
//                    while ((count = socketChannel.read(byteBuffer)) != -1) {
//                        System.out.println("count=" + count);
//                        byteBuffer.flip();
//                        System.out.println(charset.decode(byteBuffer));
//                        if (byteBuffer.hasRemaining()) {
//                            byteBuffer.compact();
//                        } else {
//                            byteBuffer.clear();
//                        }
//                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
