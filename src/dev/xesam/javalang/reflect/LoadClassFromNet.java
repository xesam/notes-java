package dev.xesam.javalang.reflect;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xe on 14-11-5.
 */
public class LoadClassFromNet {

    public static String pkg = "ygkj.task";
    public static String cls = "Dog";

    public static void main(String[] args) {
        try {
            URL url = new URL("http://127.0.0.1/" + cls + ".class");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openConnection().getInputStream());
            final byte[] bytes = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bytes);
            bufferedInputStream.close();
            Class c = new ClassLoader() {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    return defineClass(name, bytes, 0, bytes.length);
                }
            }.loadClass(pkg + "." + cls);
            Field f = c.getDeclaredField("name");
            f.setAccessible(true);
            System.out.println(f.get(c.newInstance()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
