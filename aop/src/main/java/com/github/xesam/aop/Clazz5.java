package com.github.xesam.aop;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public class Clazz5 {
    public static void main(String[] args) {
        Clazz5 clazz = new Clazz5();
        clazz.fn(20, "xesam");
    }

    int age = 100;

    public void fn(int age, String name) {
        this.age = age;
        System.out.println(this.age);
    }
}
