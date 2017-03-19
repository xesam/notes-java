package dev.xesam.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by xesamguo@gmail.com on 17-3-19.
 */
public class FibonacciExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciExample.class);

    public static void main(final String[] args) throws Exception {
        final long index = 12;
        final FibonacciExample example = new FibonacciExample();
        final long fn = example.getNumber(index);
        FibonacciExample.LOGGER.debug("The {}th Fibonacci number is: {}", index, fn);
    }

    private final Cache1<Long, Long> cache = new Cache1<>();

    public FibonacciExample() {
        cache.setValueIfAbsent(0L, 1L);
        cache.setValueIfAbsent(1L, 1L);
    }

    public long getNumber(final long index) throws Exception {
        return cache.getValue(index, new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                FibonacciExample.LOGGER.debug("Computing the {} Fibonacci number", index);
                return getNumber(index - 1) + getNumber(index - 2);
            }
        });
    }
}
