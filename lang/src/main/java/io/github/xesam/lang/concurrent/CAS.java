package io.github.xesam.lang.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by xe on 16-5-31.
 */
public class CAS {
    public static void main(String[] args) {
        AtomicBoolean locked = new AtomicBoolean(false);
        System.out.println(locked.compareAndSet(false, true));
        System.out.println(locked.get());
    }
}
