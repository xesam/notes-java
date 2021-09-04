package io.github.xesam.java8.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.parse("12:00");
        System.out.println(time1.getHour());
        LocalTime time2 = LocalTime.parse("12/00", DateTimeFormatter.ofPattern("HH/MM"));
        System.out.println(time2.getHour());
        LocalTime time3 = LocalTime.parse("12 00", DateTimeFormatter.ofPattern("HH MM"));
        System.out.println(time3.getHour());
        LocalTime time4 = LocalTime.parse("12：00", DateTimeFormatter.ofPattern("HH：MM"));
        System.out.println(time4.getHour());
    }
}
