package io.github.xesam.lang.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by xe on 15-5-15.pu
 */
public class AioFutureEchoServer {

    static int PORT = 1234;

    public AioFutureEchoServer() {

    }

    public static void main(String[] args) {
        new AioFutureEchoServer().start();
    }

    public void start() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try (AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open()) {
            asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
            asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            asynchronousServerSocketChannel.bind(new InetSocketAddress(PORT));

            while (true) {

                Future<AsynchronousSocketChannel> asynchronousSocketChannelFuture = asynchronousServerSocketChannel.accept();
                final AsynchronousSocketChannel asynchronousSocketChannel = asynchronousSocketChannelFuture.get();

                executorService.submit(() -> {
                    try {
                        System.out.println("Incoming connection from: " + asynchronousSocketChannel.getRemoteAddress());

                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

                        while (asynchronousSocketChannel.read(byteBuffer).get() != -1) {
                            byteBuffer.flip();
                            asynchronousSocketChannel.write(byteBuffer);
                            if (byteBuffer.hasRemaining()) {
                                byteBuffer.compact();
                            } else {
                                byteBuffer.clear();
                            }
                        }
                    } catch (IOException | InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });


            }

        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
