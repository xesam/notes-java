package io.github.xesam.lang.nio;

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
        IntStream.range(0, 10).forEach((i) -> new BlockingEchoClient().start());
//        new BlockingEchoClient().start();
    }

    public static class BlockingEchoClient {
        public void start() {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(true);
                socketChannel.connect(new InetSocketAddress("localhost", NioNonBlockingEchoServer.SERVER_PORT));
                Charset charset = Charset.defaultCharset();
                if (socketChannel.isConnected()) {
                    ByteBuffer out = ByteBuffer.allocate(1024);
                    out.put("0123456789".getBytes());
                    out.flip();
                    socketChannel.write(out);
                    Thread.sleep(500);
                    out.clear();
                    out.put("abcdefghijklmn".getBytes()).put(NioBlockingEchoServer.END);
                    out.flip();
                    socketChannel.write(out);

                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while (socketChannel.read(byteBuffer) != -1) {
                        boolean reachEnd = false;
                        int pos = byteBuffer.position();
                        if (pos == 0) {
                            reachEnd = true;
                        }
                        if (byteBuffer.get(pos - 1) == NioBlockingEchoServer.END) {
                            reachEnd = true;
                        }
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
