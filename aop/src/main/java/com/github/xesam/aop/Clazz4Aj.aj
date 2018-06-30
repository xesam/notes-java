package com.github.xesam.aop;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public aspect Clazz4Aj {
    //切入点
    pointcut constructorPointCut():
            call(com.github.xesam.aop.Clazz4.new());

    //通知块
    before(): constructorPointCut(){
        System.out.println("constructorPointCut");
    }

}
