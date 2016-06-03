package dev.xesam.javalang.aio;


import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xe on 15-5-10.
 */
public class AsynchronousFileChannelTest {

    public static void main(String[] args) throws Exception {

        String filePath = "/home/xe/git/osc/JavaNote/Lang/data/Test.java";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<OpenOption> openOptions = new HashSet<>(Arrays.asList(new StandardOpenOption[]{StandardOpenOption.READ}));

        try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(Paths.get(filePath), openOptions, executorService)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            asynchronousFileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("completed,result = " + result);
                    executorService.shutdown();
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("failed");
                    exc.printStackTrace();
                    executorService.shutdown();
                }
            });
        } catch (Exception e) {
        }
    }
}

