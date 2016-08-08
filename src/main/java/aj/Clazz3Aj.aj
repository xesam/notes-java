package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public aspect Clazz3Aj {
    pointcut exceptionPointcut():
            handler(MyException);

    before():exceptionPointcut(){
        System.out.println("handle MyException");
        System.out.println("handle MyException:" + thisJoinPoint.getArgs()[0]);//与 arg() 的异同点
    }
}
