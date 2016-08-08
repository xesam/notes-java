package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public aspect Clazz5Aj {
    pointcut getPointCut():
            get(int aj.Clazz5.age);

    after() returning(int age):getPointCut(){
        System.out.println("get age = " + age);
    }

}
