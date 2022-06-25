package io.github.xesam.lang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
    public static void main(String[] args) {
//        testMatch("a");
        testLookingAt("a");
//        testMatch("ab");
//        testMatch("abc");
//        testMatch("abc123");
//        testFind(bc123");
//        testLookingAt("abc123");
    }

    public static void testMatch(String input) {
        Pattern pattern = Pattern.compile("([a-z])");
        Matcher matcher = pattern.matcher(input);
        inspect(matcher);
    }

    public static void testFind(String input) {
        Pattern pattern = Pattern.compile("([a-z])");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("[" + matcher.start() + " , " + matcher.end() + "]");
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
    }

    public static void testLookingAt(String input) {
        Pattern pattern = Pattern.compile("([a-z])");
        Matcher matcher = pattern.matcher(input);
        System.out.print(matcher.lookingAt());
        inspectMatcherStartEnd(matcher);
        inspectMatcherGroups(matcher);

        matcher.region(matcher.end(), input.length());
        System.out.print(matcher.lookingAt());
        inspectMatcherStartEnd(matcher);

        matcher.region(matcher.end(), input.length());
        System.out.print(matcher.lookingAt());
        inspectMatcherStartEnd(matcher);

        matcher.region(matcher.end(), input.length());
        System.out.print(matcher.lookingAt());
    }


    public static void inspectMatcherStartEnd(Matcher matcher) {
        System.out.println("[" + matcher.start() + " , " + matcher.end() + "]");
    }

    public static void inspectMatcherGroups(Matcher matcher) {
        for (int i = 0; i <= matcher.groupCount(); i++) {
            System.out.printf("matcher.group(%d)= %s%n", i, matcher.group(i));
        }
    }

    public static void inspect(Matcher matcher) {
        System.out.println("#################");
        System.out.println("matcher.pattern()=" + matcher.pattern());
        System.out.println("matcher.groupCount()=" + matcher.groupCount());
        System.out.print("matcher.matches()=" + matcher.matches());
        if (matcher.matches()) {
            System.out.print("[" + matcher.start() + " , " + matcher.end() + "]");
        }
        System.out.println("");
    }
}
