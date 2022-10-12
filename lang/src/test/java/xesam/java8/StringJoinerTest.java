package xesam.java8;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.StringJoiner;

public class StringJoinerTest {
    @Test
    public void when_delimiter_is_empty() {
        StringJoiner stringJoiner = new StringJoiner("");
        stringJoiner.add("a").add("b");
        assertEquals("ab", stringJoiner.toString());
    }

    @Test
    public void when_delimiter_is_not_empty() {
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("a").add("b");
        assertEquals("a,b", stringJoiner.toString());
    }

    @Test
    public void when_delimiter_prefix_suffix_is_not_empty() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("a").add("b");
        assertEquals("[a,b]", stringJoiner.toString());
    }

    @Test
    public void when_emptyValue_is_not_empty() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]").setEmptyValue("--");
        assertEquals("--", stringJoiner.toString());
    }
}
