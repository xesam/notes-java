package com.github.xesam.aop;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public class Clazz2 {
    public static void main(String[] args) {
        Clazz2 clazz2 = new Clazz2();
        clazz2.fn(20, "xesam");
    }

    public void fn(int age, String name) {
        System.out.println("invoke fn");
    }
}
