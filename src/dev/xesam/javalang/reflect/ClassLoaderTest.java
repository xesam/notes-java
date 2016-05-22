package dev.xesam.javalang.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xe xesamguo@gmail.com on 14-9-27.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        final MyClassLoader myClassLoader1 = new MyClassLoader();

        //同一个类加载器只会加载一次同一个类
        Class<?> clazz_1 = myClassLoader1.loadClass("Test");
        Class<?> clazz_1_2 = myClassLoader1.loadClass("Test");
        System.out.println("clazz_1 == clazz_1_2:" + (clazz_1 == clazz_1_2));
        System.out.println("###########");
        //不同类加载器加载的类不一样
        MyClassLoader myClassLoader2 = new MyClassLoader();
        Class<?> clazz_2 = myClassLoader2.loadClass("Test");
        System.out.println("clazz_1 == clazz_2:" + (clazz_1 == clazz_2));
        System.out.println("###########");
        //不要显式引用一个类，因为显式引用一个类表示编译器可以看到这个类，所以系统类加载器会去加载这个类
        Method hello = clazz_1.getDeclaredMethod("hello", null);
        hello.invoke(clazz_1.newInstance(), null);

        new Thread() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("###########");
                //注意loadClass(String name)的参数问题
                try {
                    Class<?> clazz_1_3 = myClassLoader1.loadClass("Test_Error");
                    Class<?> clazz_1_4 = myClassLoader1.loadClass("Test_Error");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


        System.out.println("###########");

        //Class.forName() 与 loadClass()的不同之处，
        Class.forName("Test", true, new MyClassLoader());
    }

    private static class MyClassLoader extends ClassLoader {
        private MyClassLoader() {
            super();
        }

        private MyClassLoader(ClassLoader parent) {
            super(parent);
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            System.out.println("loadClass:" + name);
            return super.loadClass(name);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                File file = new File("Test.class");
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
