package com.github.xesam.aop;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public class Clazz6 {
    public static void main(String[] args) {
        Clazz6 clazz = new Clazz6();
        clazz.fn(20, "xesam");
    }

    @MyAnnotation("name")
    public void fn(int age, String name) {
        System.out.println("age = " + age + ",name = " + name);
    }
}
