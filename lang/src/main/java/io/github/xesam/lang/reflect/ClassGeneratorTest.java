package io.github.xesam.lang.reflect;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xe on 2014/10/10.
 * xesamguo@gmail.com
 */
public class ClassGeneratorTest {
    public static void main(String[] args) {
//        File f0 = new File("Hello.class");
//        if (f0.exists()) {
//            System.out.println(f0.delete());
//        }
//        boolean a = true;
//        if (a)
//            throw new RuntimeException("");
        try {
            File javaFile = new File("Hello.java");
            FileOutputStream fileOutputStream = new FileOutputStream(javaFile);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.write("public class Hello{public static void main(String[] args) {System.out.println(\"[Hello.class]hello\");}}");
            printWriter.flush();
            printWriter.close();
            fileOutputStream.close();
            Process process = Runtime.getRuntime().exec("javac Hello.java");
            process.waitFor();
            if (process.exitValue() == 0) {
//                Class clazz = Class.forName("Hello");
                TmpClassLoader tmpClassLoader = new TmpClassLoader();
                Class clazz = tmpClassLoader.loadClass("Hello");
                Method method = clazz.getDeclaredMethod("main", new Class[]{String[].class});
                method.invoke(null, new Object[]{null});

            } else {
                InputStream inputStream = process.getErrorStream();
                while (inputStream.available() != 0) {
                    System.out.println(inputStream.read());
                }
                inputStream.close();
            }

            if (javaFile.exists()) {
                javaFile.delete();
            }

            File f = new File("Hello.class");
            if (f.exists()) {
                System.out.println(f.delete());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static class TmpClassLoader extends ClassLoader {
        public TmpClassLoader() {

        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                File file = new File(name + ".class");
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                fileInputStream.read(bytes);
                fileInputStream.close();
                return defineClass(name, bytes, 0, bytes.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
