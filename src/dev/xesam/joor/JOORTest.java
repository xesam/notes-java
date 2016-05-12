package dev.xesam.joor;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.joor.Reflect;
import org.junit.Test;

/**
 * Created by xe on 16-5-12.
 */
public class JOORTest extends TestCase {

    public interface StringProxy {
        String substring(int beginIndex);
    }

    @Test
    public void test1() {
        String world = Reflect.on("java.lang.String")  // 同 Class.forName()
                .create("Hello World") // Call most specific matching constructor
                .call("substring", 6)  // Call most specific matching substring() method
                .call("toString")      // Call toString()
                .get();                // Get the wrapped object, in this case a String
        Assert.assertEquals("World", world);
    }

    @Test
    public void test2() {
        String substring = Reflect.on("java.lang.String")
                .create("Hello World")
                .as(StringProxy.class) // Create a proxy for the wrapped object
                .substring(6);         // Call a proxy method
        Assert.assertEquals("World", substring);
    }
}
