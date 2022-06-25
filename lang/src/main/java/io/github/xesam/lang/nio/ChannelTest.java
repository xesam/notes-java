package io.github.xesam.lang.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * Created by xe xesamguo@gmail.com on 14-9-27.
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        byteBuffer.clear();
        FileOutputStream fos = new FileOutputStream("/tmp/nio.txt");
        FileChannel outChannel = fos.getChannel();
        byteBuffer.put("hello".getBytes());
        outChannel.write(byteBuffer);
        outChannel.close();

        byteBuffer.clear();
        byteBuffer.flip();
        FileInputStream fileInputStream = new FileInputStream(new File("/tmp/nio.txt"));
        FileChannel inChannel = fileInputStream.getChannel();
        System.out.println(inChannel.read(byteBuffer));
        byteBuffer.compact();
        byte[] dest = new byte[byteBuffer.limit()];
        byteBuffer.get(dest);
        System.out.println(new String(dest));
        inChannel.close();

    }
}
