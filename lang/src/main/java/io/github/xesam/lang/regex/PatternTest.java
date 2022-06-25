package io.github.xesam.lang.regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String[] args) {
        String s = "a slash \"\\\"";
        System.out.println(s);
        Pattern pattern = Pattern.compile("a slash \"\\\\\"");
        System.out.println(pattern.matcher(s).matches());
    }

    @Test
    public void testSlash() {
        String pat = "\\\\";
        Assert.assertTrue("\\".matches(pat));
        Assert.assertTrue("\\".matches(pat));
    }

    @Test
    public void testQuote() {
        String pat = "\"";
        Assert.assertTrue("\"".matches(pat));
        Assert.assertFalse("'".matches(pat));
    }

    @Test
    public void testPunct() {
        String pat = "\\p{Punct}";
        Assert.assertTrue(".".matches(pat));
        Assert.assertTrue(":".matches(pat));
        Assert.assertTrue("_".matches(pat));
        Assert.assertTrue("?".matches(pat));
        Assert.assertTrue("*".matches(pat));
        Assert.assertFalse("a".matches(pat));
    }
}
