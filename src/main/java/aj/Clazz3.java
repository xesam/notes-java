package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-8.
 */
public class Clazz3 {
    public static void main(String[] args) {
        Clazz3 clazz = new Clazz3();
        clazz.fn(20, "xesam");
    }

    public void fn(int age, String name) {
        try {
            throw new MyException();
        } catch (MyException e) {
        }
    }
}
