package com.github.xesam.aop;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public aspect Clazz5Aj {
    pointcut getPointCut():
            get(int com.github.xesam.aop.Clazz5.age);

    after() returning(int age):getPointCut(){
        System.out.println("get age = " + age);
    }

}
