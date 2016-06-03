package dev.xesam.javalang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by xe on 15-5-15.
 */
public class NioBlockingEchoServer {

    public static final byte END = 0x00;

    public static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        new BlockingEchoServer().start();
    }

    public static class BlockingEchoServer {

        public void start() {
            try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
                serverSocketChannel.bind(new InetSocketAddress(SERVER_PORT));
                serverSocketChannel.configureBlocking(true);
                System.out.println("waiting for connect ");

                while (true) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    handle(socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void handle(SocketChannel socketChannel) throws IOException {
            Charset charset = Charset.defaultCharset();
            System.out.println("\ncoming from " + socketChannel.getRemoteAddress());
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (socketChannel.read(byteBuffer) != -1) {
                boolean reachEnd = false;
                int pos = byteBuffer.position();
                if (pos == 0) {
                    reachEnd = true;
                }
                if (byteBuffer.get(pos - 1) == END) {
                    reachEnd = true;
                }
                byteBuffer.flip();
                System.out.println("[get]" + charset.decode(byteBuffer));
                byteBuffer.rewind();
                socketChannel.write(byteBuffer);
                if (reachEnd) {
                    System.out.println("reach end");
                    break;
                } else {
                    byteBuffer.clear();
                }
            }
            socketChannel.close();

        }

    }
}
