package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public aspect Clazz4Aj {
    //切入点
    pointcut constructorPointCut():
            call(aj.Clazz4.new());

    //通知块
    before(): constructorPointCut(){
        System.out.println("constructorPointCut");
    }

}
