package io.github.xesam.java8.stream;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CustomCollector {

    static class SimpleCollector<T, A, R> implements Collector<T, A, R> {
        @Override
        public Supplier<A> supplier() {
            return null;
        }

        @Override
        public BiConsumer<A, T> accumulator() {
            return null;
        }

        @Override
        public BinaryOperator<A> combiner() {
            return null;
        }

        @Override
        public Function<A, R> finisher() {
            return null;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return null;
        }
    }

    public static void main(String[] args) {
        final int DISTANCE = 2;
        Supplier<Deque<Deque<Integer>>> supplier = () -> {
            Deque<Deque<Integer>> container = new ArrayDeque<>();
            container.add(new ArrayDeque<>());
            return container;
        };

        BiConsumer<Deque<Deque<Integer>>, Integer> accumulator = (ints, ele) -> {
            Deque<Integer> lastGroup = ints.getLast();
            if (!lastGroup.isEmpty() && Math.abs(lastGroup.getLast() - ele) > DISTANCE) {
                Deque<Integer> newGroup = new ArrayDeque<>();
                newGroup.add(ele);
                ints.add(newGroup);
            } else {
                lastGroup.add(ele);
            }
        };

        BinaryOperator<Deque<Deque<Integer>>> combiner = (left, right) -> {
            Deque<Integer> leftLast = left.getLast();
            if (leftLast.isEmpty()) {
                return right;
            }
            Deque<Integer> rightFirst = right.getFirst();
            if (rightFirst.isEmpty()) {
                return left;
            }
            Integer i = rightFirst.getFirst();
            if (Math.abs(leftLast.getLast() - i) <= DISTANCE) {
                leftLast.addAll(rightFirst);
                right.removeFirst();
            }
            left.addAll(right);
            return left;
        };

        Deque<Deque<Integer>> queues = Stream.of(1, 2, 3, 10, 12, 13, 101, 102, 103)
                .collect(Collector.of(supplier, accumulator, combiner));
        System.out.println(queues.size());
    }
}













