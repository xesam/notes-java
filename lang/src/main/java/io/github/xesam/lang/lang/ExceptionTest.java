package io.github.xesam.lang.lang;

/**
 * Created by xe on 14-12-3.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.unchecked();

        try {
            exceptionTest.unchecked();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

        try {
            exceptionTest.checked();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
        }
    }

    public void unchecked() throws NullPointerException {
        throw new NullPointerException();
    }

    public void checked() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
}
