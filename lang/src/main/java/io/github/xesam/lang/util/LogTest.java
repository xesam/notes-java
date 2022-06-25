package io.github.xesam.lang.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Created by xe on 16-6-3.
 */
public class LogTest {
    static Logger logger = LoggerFactory.getLogger(LogTest.class.getName());

    public static void main(String[] args) {
        IntStream.range(0, 3).forEach(i -> logger.debug(i + ""));
        LogTest logTest = new LogTest();
        logTest.log_1();
    }

    public void log_1() {
        System.out.println("this is default");
    }
}
