package dev.xesam.java8.time;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by xe on 18-1-2.
 */
public class LocalDateTest {
    public static void main(String[] args) {
        Instant s = Instant.now();
        Instant e = Instant.now();
        Duration d = Duration.between(s, e);
        System.out.println(d.toMillis());
    }
}
