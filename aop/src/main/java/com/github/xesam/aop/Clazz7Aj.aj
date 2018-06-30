package com.github.xesam.aop;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public aspect Clazz7Aj {
    pointcut fn2():
            call(* com.github.xesam.aop.Clazz7.fn2());

    declare error:
            fn2() && !within(com.github.xesam.aop.Clazz7Aj):
            "hehehe";

    pointcut fn(Clazz7 clazz):
            call(* com.github.xesam.aop.Clazz7.fn(int, java.lang.String))
            && this(clazz);

    before(Clazz7 clazz): fn(clazz){
        System.out.println("aop:before fn");
        clazz.fn2();
    }
}
