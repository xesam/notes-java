package io.github.xesam.lang.reflect.sample;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by xe on 18-1-3.
 */
public class ApiReflect {
    public static void main(String[] args) {
        set(Api.class, "HOST", "456");
        Api.inspect();

        Api api = new Api();
        setObject(api, "port", 1000);
        api.inspectSelf();
    }

    public static <T> void set(Class<?> claszz, String filed, T value) {
        try {
            Field f = claszz.getDeclaredField(filed);
            boolean rawAccessible = f.isAccessible();
            f.setAccessible(true);
            f.set(null, value);
            f.setAccessible(rawAccessible);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> void setObject(Object target, String filed, T value) {
        try {
            Field f = target.getClass().getDeclaredField(filed);
            boolean rawAccessible = f.isAccessible();
            f.setAccessible(true);
            Field modifiers = f.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            int rawModifiers = f.getModifiers();
            modifiers.setInt(f, rawModifiers & ~Modifier.FINAL);
            f.set(target, value);
            modifiers.setInt(f, rawModifiers);
            System.out.println(f.getInt(target));//final 变量被优化到代码里面去了。
            f.setAccessible(rawAccessible);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
