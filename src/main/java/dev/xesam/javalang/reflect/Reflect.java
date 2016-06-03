package dev.xesam.javalang.reflect;

import java.lang.reflect.*;

/**
 * Created by xe on 14-12-18.
 */
public class Reflect<T extends Method> {

    static Class clazz;

    static Modifier modifier;

    static Member member;
    static Method method;
    static Field field;
    static Constructor constructor;

    static Array array;

    public static void main(String[] args) throws NoSuchMethodException {
//        field.getGenericType()
//        Reflect.class.getConstructor().getParameters();
        System.out.println(Reflect.class.getConstructors());

    }
}
