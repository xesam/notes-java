package io.github.xesam.lang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherBounds {
    public static void main(String[] args) {
        useAnchoringBounds();
//        useTransparentBounds();
    }

    public static void testMatch(String text, Matcher matcher) {
        matcher.region(4, text.length());
        if (matcher.find()) {
            System.out.println("Matches start : " + matcher.start());
        } else {
            System.out.println("not match");
        }
    }

    public static void useAnchoringBounds() {
        String text = "abcdefg hijk";
        Pattern regex1 = Pattern.compile("^efg");
        Pattern regex2 = Pattern.compile("\\befg");
        testMatch(text, regex1.matcher(text).useAnchoringBounds(false));
        testMatch(text, regex1.matcher(text).useAnchoringBounds(true));
        testMatch(text, regex2.matcher(text).useAnchoringBounds(false));
        testMatch(text, regex2.matcher(text).useAnchoringBounds(true));
    }

    public static void useTransparentBounds() {
        String text = "abcdefg hijk";
        Pattern regex1 = Pattern.compile("^efg");
        Pattern regex2 = Pattern.compile("\\befg");
        testMatch(text, regex1.matcher(text).useTransparentBounds(false));
        testMatch(text, regex1.matcher(text).useTransparentBounds(true));
        testMatch(text, regex2.matcher(text).useTransparentBounds(false));
        testMatch(text, regex2.matcher(text).useTransparentBounds(true));
    }
}
