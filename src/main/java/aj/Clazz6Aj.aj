package aj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
@Aspect
public class Clazz6Aj {
    @Before("within(@aj.MyAnnotation *) || execution(@aj.MyAnnotation * *(..))")
    public void before() {
        System.out.println("Clazz6Aj before");
    }
}
