package io.github.xesam.lang.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by xe on 15-2-23.
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {
            Class.forName("java.lang.String");
            Class.forName("dev.xesam.java.lang.reflect.ClassLoaderTest2");

            Cl cl = new Cl();
            Class<?> clazz = cl.loadClass("data.Test");
            System.out.println(clazz);

            Class<?> clazz2 = cl.loadClass("data.Test");
            Runnable runnable = (Runnable) clazz2.newInstance();
            runnable.run();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static class Cl extends ClassLoader {
        public Cl() {
            super();
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            System.out.println("loadClass:" + name);
            return super.loadClass(name);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            String userDir = System.getProperty("user.dir") + File.separator + "Lang";
            System.out.println(userDir);
            String targetClassName = userDir + File.separator + name.replaceAll("\\.", File.separator) + ".class";
            System.out.println(targetClassName);
            try {
                File file = new File(targetClassName);
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                fileInputStream.read(bytes);
                fileInputStream.close();
                return defineClass(null, bytes, 0, bytes.length);
            } catch (FileNotFoundException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
