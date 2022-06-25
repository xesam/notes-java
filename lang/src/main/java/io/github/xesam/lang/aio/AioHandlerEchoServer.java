package io.github.xesam.lang.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xe on 15-5-15.pu
 */
public class AioHandlerEchoServer {
    static int PORT = 1234;

    public AioHandlerEchoServer() {

    }

    public static void main(String[] args) {
        new AioHandlerEchoServer().start();
    }

    public void start() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        AsynchronousChannelGroup asynchronousChannelGroup = null;
        try {
            asynchronousChannelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open(asynchronousChannelGroup)) {
            asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
            asynchronousServerSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            asynchronousServerSocketChannel.bind(new InetSocketAddress(PORT));

            asynchronousServerSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
                @Override
                public void completed(AsynchronousSocketChannel asynchronousSocketChannel, Void attachment) {
                    asynchronousServerSocketChannel.accept(attachment, this);
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
                    } finally {
                        try {
                            asynchronousSocketChannel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    asynchronousServerSocketChannel.accept(attachment, this);
                    exc.printStackTrace();
                }
            });
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
