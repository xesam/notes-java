package io.github.xesam.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Collector {

    public static void main(String[] args) {
        toFrameworkList();
        toLinkedList();
        toFrameworkMap();
        toTreeMap();
        joining();
        groupingBy();
        groupingBy2();
        groupingBy3();
    }

    static void joining() {
        String result = Stream.of("A", "B", "C", "D")
                .collect(Collectors.joining(",", "pre__", "__post"));
        System.out.println(result);
    }

    static void groupingBy() {
        Map<String, List<String>> result = Stream.of("A", "A", "B", "C", "D")
                .collect(Collectors.groupingBy(e -> e));
        System.out.println(result.get("A"));
    }

    static void groupingBy2() {
        Map<String, Set<String>> result = Stream.of("A", "A", "B", "C", "D")
                .collect(Collectors.groupingBy(e -> e, Collectors.toSet()));
        System.out.println(result.get("A"));
    }

    static void groupingBy3() {
        Map<String, Long> result = Stream.of("A", "A", "B", "C", "D")
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(result.get("A"));
    }

    static void toFrameworkList() {
        List<String> elements = Stream.of("A", "B")
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(elements.size());
    }

    static void toLinkedList() {
        LinkedList<String> elements = Stream.of("A", "B")
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(elements.size());
    }

    static void toFrameworkMap() {
        Map<String, String> elements = Stream.of("A", "B", "A")
                .map(String::toLowerCase)
                .collect(Collectors.toMap(e -> e, e -> e, String::concat));
        System.out.println(elements.get("a"));
    }

    static void toTreeMap() {
        Map<String, String> elements = Stream.of("A", "B", "A")
                .map(String::toLowerCase)
                .collect(Collectors.toMap(e -> e, e -> e, String::concat, TreeMap::new));
        System.out.println(elements.get("a"));
    }
}
