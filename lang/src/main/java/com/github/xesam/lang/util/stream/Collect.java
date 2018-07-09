package com.github.xesam.lang.util.stream;

import javafx.util.Pair;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collect {
    @Test
    public void collect() {
        List<Pair<String, String>> pairs = IntStream.range(0, 10)
                .mapToObj(i -> new Pair<>("key" + i, "value" + i))
                .collect(Collectors.toList());

        pairs.forEach(System.out::println);
    }
}
