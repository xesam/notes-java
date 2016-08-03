package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-3.
 */
public class MySubClass extends MyClass {
    @Override
    public void foo(int value, String name) {
        System.out.println("sub foo");
    }
}
