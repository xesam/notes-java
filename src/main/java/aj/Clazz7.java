package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public class Clazz7 {
    public static void main(String[] args) {
        Clazz7 clazz = new Clazz7();
        clazz.fn(20, "xesam");
    }

    public void fn(int age, String name) {
        System.out.println("age = " + age + ",name = " + name);
//        fn2(); //trigger ajc declare error
    }

    public void fn2() {
        System.out.println("this is fn2");
    }
}
