package dev.xesam.javalang.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Created by xe on 16-6-3.
 */
public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i -> logger.debug(i + ""));
    }
}
