package com.github.xesam.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
@Aspect
public class Clazz6Aj {
    @Before("within(@com.github.xesam.aop.MyAnnotation *) || execution(@com.github.xesam.aop.MyAnnotation * *(..))")
    public void before() {
        System.out.println("Clazz6Aj before");
    }

    @After("within(@com.github.xesam.aop.MyAnnotation *) || execution(@com.github.xesam.aop.MyAnnotation * *(..))")
    public void after() {
        System.out.println("Clazz6Aj after");
    }
}
