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
        IntStream.range(0, 3).forEach((i) -> new BlockingEchoClient().start());
    }

    public static class BlockingEchoClient {
        public void start() {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(true);
                socketChannel.connect(new InetSocketAddress("localhost", NioNonBlockingEchoServer.SERVER_PORT));
                Charset charset = Charset.defaultCharset();
                if (socketChannel.isConnected()) {
                    socketChannel.write(ByteBuffer.wrap("01234567".getBytes()));
                    ByteBuffer byteBuffer = ByteBuffer.allocate(8);
                    while (socketChannel.read(byteBuffer) != -1) {
                        boolean reachEnd = byteBuffer.hasRemaining();//没有读满则认为到达了结尾
                        byteBuffer.flip();
                        System.out.println(charset.decode(byteBuffer));
                        if (reachEnd) {
                            break;
                        } else {
                            byteBuffer.clear();
                        }
                    }
                    socketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
