package dev.xesam.javalang.lang;

/**
 * Created by xe on 14-12-19.
 */

/**
 * You can either Widen or Box but you cannot do both, unless you are boxing and widening to Object (An int to Integer(Boxing) and then Integer to Object(Widening) is legal, since every class is a subclass of Object, so it is possible for Integer to be passed to Object parameter)
 */


public class VarArgsTest {

    public static void main(String[] args) throws Exception {
        divider();
        testString("a", "b", "c");//3
        divider();
        testString(new String[]{"a", "b", "c"});//3
        divider();
        testString("a0", new String[]{"a", "b", "c"});//2
        divider();
        testObject("a", "b", "c");//3
        divider();
        testObject(new String[]{"a", "b", "c"});//3
        divider();
        testObject("a0", new String[]{"a", "b", "c"});//2
    }

    public static void divider() {
        System.out.println("####################################");
    }

    public static void testString(String... args) {
        System.out.println("testString:" + args.length);
    }

    public static void testString(Object obj, String... args) {
        System.out.println("testString:" + args.length);
    }

    public static void testObject(Object... args) {
        System.out.println("testObject:" + args.length);


    }

//
//    public static void main(String[] args) {
//        test1(new String[]{"a", "b", "c"}); //3
//        test1(1, new String[]{"a", "b", "c"});//2
//
//        test1(new Integer[]{2, 3, 4}); //3
//        test1(1, new Integer[]{2, 3, 4});//2
//        test1(1, new Integer[]{2, 3, 4}, new Integer[]{2, 3, 4});//3
//
//        test1(2, 3, 4);//3
//        test1(new int[]{2, 3, 4});//1
//        test1(1, new int[]{2, 3, 4});//2
//
//    }

    public static void test1(Object... varargs) {
        System.out.println(varargs.length);
    }

}
