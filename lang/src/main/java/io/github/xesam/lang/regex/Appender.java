package io.github.xesam.lang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Appender {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        String testStr = "i have 100, you have 200";
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(testStr);
        while (matcher.find()) {
            matcher.appendReplacement(sb, Integer.parseInt(matcher.group()) * 100 + "");
        }
        matcher.appendTail(sb);
        System.out.println(sb);
    }
}
