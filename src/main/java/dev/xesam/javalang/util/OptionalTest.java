package dev.xesam.javalang.util;

import java.util.Optional;

/**
 * Created by xe on 14-12-3.
 */
public class OptionalTest {
    public static void main(String[] args) {

        //static
        Optional<String> optional = Optional.ofNullable("hello");
        Optional<String> optional_2 = Optional.of("str");
        Optional.<String>empty();

        System.out.println(optional.isPresent());
        if (!optional.isPresent()) {
            System.out.println("optional is not set!");
            return;
        }

        optional.get();
        optional.ifPresent((value) -> System.out.println("hello"));

        optional.orElse("elseValue");
        optional.orElseGet(() -> "orElseGet");
        optional.orElseThrow(RuntimeException::new);

        //filter:过滤
        optional.filter((value) -> value.length() == 5);

        optional.map((value) -> {
            System.out.println("map:" + value);
            return value;
        });

        optional.flatMap((value) -> {
            System.out.println("flatMap:" + value);
            return Optional.ofNullable(value);
        });

    }
}
