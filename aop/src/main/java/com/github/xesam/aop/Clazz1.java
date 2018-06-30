package com.github.xesam.aop;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public class Clazz1 {
    public static void main(String[] args) {
        Clazz1 clazz1 = new Clazz1();
        clazz1.fn(20, "xesam");
    }

    public void fn(int age, String name) {
        System.out.println("invoke fn");
    }
}
