package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-3.
 */
public aspect MyClassAj {

    //切入点
    pointcut dPointCut(Object tar, int value, String name):
            call(public void aj.MyClass.foo(int, String))
                    && args(value, name)
                    && target(tar);

    //通知块
    before(Object tar, int value, String name): dPointCut(tar,value, name){
        System.out.println("before,target=" + tar + " args = (" + value + "," + name + ")");
    }

    //通知块
    after(Object tar, int value, String name): dPointCut(tar,value, name){
        System.out.println("after");
    }

    //execution 是进入方法体之后
    pointcut ePointCut(Object thiz):
            execution(void aj.MyClass.fn2())
                    &&this(thiz);

    before(Object thiz):ePointCut(thiz){
        System.out.println("fn2 execute, this = " + thiz);
        System.out.println(thisJoinPoint.getSignature());
    }

    pointcut exceptionPointcut():
            handler(MyException);

    before():exceptionPointcut(){
        System.out.println("handle MyException");
        System.out.println("handle MyException:" + thisJoinPoint.getArgs()[0]);//与 arg() 的异同点
    }
}
