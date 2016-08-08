package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public aspect Clazz1Aj {
    //切入点
    pointcut dPointCut(Object tar, int value, String name):
            call(public void aj.Clazz1.fn(int, String))
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
}
