package aj;

/**
 * Created by xesamguo@gmail.com on 16-8-3.
 */
public class MyClass {
    public static void main(String[] args) {
        MyClass myClass = new MySubClass();
        myClass.foo(1, "Hello world");
        MyClass myClass2 = new MyClass();
        myClass2.foo(2, "Hello world");

        try {
            throw new MyException();
        } catch (MyException e) {
//            System.err.println("error occur");
        }
        System.out.println(myClass2.age);
    }

    private int age = 20;

    @MyAnnotation("name")
    public void foo(int value, String name) {
        System.out.println("Inside foo (int, String)");
        fn2();
    }

    public void fn2() {
        System.out.println("fn2 invoke");
    }
}
