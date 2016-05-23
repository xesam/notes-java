public class Hello {

    public static void staticSay() {
        System.out.println("static hello");
    }

    private String name = "default";

    public Hello() {
    }

    public Hello(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("hello");
    }
}