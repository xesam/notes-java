package io.github.xesam.lang.lang;

/**
 * Created by xe xesamguo@gmail.com on 14-9-25.
 */
public class NestedClasses {
    private static final int INT_A = 1;
    private final int INT_B = 10;

    private int a = 100;

    public static class StaticInner {
        public StaticInner() {
            int a = INT_A;
        }
    }

    public class NormalInner {
        int a;

        public NormalInner() {
            a = INT_B;
        }

        public void say(int a) {
            System.out.println("param:" + a);
            System.out.println("this.a:" + this.a);
            System.out.println("NestedClasses.this.a:" + NestedClasses.this.a);
        }
    }

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner();
        NestedClasses nestedClasses = new NestedClasses();
        NormalInner normalInner = nestedClasses.new NormalInner();
        normalInner.say(1);
    }
}
