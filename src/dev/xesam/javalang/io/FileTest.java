package dev.xesam.javalang.io;

import dev.xesam.javalang.tools.L;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by xe on 16-4-21.
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
//        listRoots();
        testFile();
    }

    public static void listRoots() {
        File[] files = File.listRoots();
        L.logList(files);
        for (File root : files) {
            System.out.println("Partition: " + root);
            System.out.println("Free space on this partition = " + root.getFreeSpace());
            System.out.println("Usable space on this partition = " + root.getUsableSpace());
            System.out.println("Total space on this partition = " + root.getTotalSpace());
            System.out.println("***");
        }

    }

    public static void testFile() throws IOException {
        File file = new File("REAMME.md");
        System.out.println("Absolute path = " + file.getAbsolutePath());
        System.out.println("Canonical path = " + file.getCanonicalPath());
        System.out.println("Name = " + file.getName());
        System.out.println("Parent = " + file.getParent());
        System.out.println("Path = " + file.getPath());
        System.out.println("Is absolute = " + file.isAbsolute());
        System.out.println("About " + file + ":");
        System.out.println("Exists = " + file.exists());
        System.out.println("Is directory = " + file.isDirectory());
        System.out.println("Is file = " + file.isFile());
        System.out.println("Is hidden = " + file.isHidden());
        System.out.println("Last modified = " + new Date(file.lastModified()));
        System.out.println("Length = " + file.length());
        System.out.println(" Execute = " + file.canExecute());
        System.out.println(" canRead = " + file.canRead());
        System.out.println(" canWrite = " + file.canWrite());
    }
}
