package dev.xesam.javalang.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 * Created by xe on 15-3-26.
 */
public class SeekableByteChannelTest {

    private static String filePath = "/tmp/SeekableByteChannel.txt";

    public static void main(String[] args) {
        write();
        read();
    }

    public static void write() {
        Path path = Paths.get(filePath);
        try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(path, EnumSet.of(StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING))) {
            ByteBuffer byteBuffer = ByteBuffer.wrap("hello world".getBytes());

            int write = seekableByteChannel.write(byteBuffer);
            System.out.println(write);
            byteBuffer.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        Path path = Paths.get(filePath);
        try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(path, EnumSet.of(StandardOpenOption.READ))) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
            String encoding = System.getProperty("file.encoding");
            byteBuffer.clear();
            while (seekableByteChannel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                System.out.println(Charset.forName(encoding).decode(byteBuffer));
                byteBuffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
