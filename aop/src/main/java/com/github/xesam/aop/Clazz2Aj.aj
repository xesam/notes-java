package com.github.xesam.aop;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public aspect Clazz2Aj {
    //execution 是进入方法体之后
    pointcut ePointCut(Object thiz):
            execution(void com.github.xesam.aop.Clazz2.fn(int, java.lang.String))
                    &&this(thiz);

    before(Object thiz):ePointCut(thiz){
        System.out.println("fn execute, this = " + thiz);
        System.out.println(thisJoinPoint.getSignature());
    }

}
