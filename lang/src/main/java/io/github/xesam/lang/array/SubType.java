package io.github.xesam.lang.array;

//数组会到运行时期才知道并去检查它里面的元素是否满足类型约束，而泛型在运行时期已经被擦除了，也就是说，编译器在构建字节码的时候会抹去一部分泛型信息
public class SubType {
    private static void sub_1() {
        Object[] objectArray = new Long[1];
        objectArray[0] = 1000L;
        System.out.println(objectArray[0]);
    }

    private static void sub_2() {
        Object[] objectArray = new Object[1];
        objectArray[0] = 1000L;
        System.out.println(objectArray[0]);
    }

    private static void sub_3() {
        Object[] objectArray = new Object[1];
        objectArray[0] = "a string";
        System.out.println(objectArray[0]);
    }

    private static void sub_4() {
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in";//error
    }

    public static void main(String[] args) {
        sub_1();
        sub_2();
        sub_3();
        sub_4();
    }
}
