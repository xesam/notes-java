package io.github.xesam.lang.aio;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by x on 2015/2/5.
 */
public class PathTest {

    public static final String fileName = "README.md";

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println(fileSystem.getRootDirectories());
        Path path = Paths.get(fileName);
        System.out.println(path.getNameCount());
        System.out.println(path.getFileName());
        System.out.println(path.getRoot());
        System.out.println(path.getParent());

        //
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toUri());
        System.out.println(path.toString());

        try {
            System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
