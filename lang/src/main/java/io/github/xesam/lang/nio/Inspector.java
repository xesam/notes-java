package io.github.xesam.lang.nio;

import java.nio.Buffer;
import java.nio.channels.SelectionKey;
import java.util.Set;

/**
 * Created by xe on 15-2-7.
 */
public final class Inspector {

    public static void inspect(Buffer buffer) {
        System.out.println("position:" + buffer.position()
                + ",limit:" + buffer.limit()
                + ",capacity:" + buffer.capacity());
    }

    public static void inspect(SelectionKey selectionKey) {
        System.out.println(
                "interestOps:" + (Integer.toBinaryString(selectionKey.interestOps()))
                        + "\nreadyOps:" + (Integer.toBinaryString(selectionKey.readyOps()))
        );
    }

    public static void inspect(Set<SelectionKey> selectionKeySet) {
        System.out.println("Set<SelectionKey> size:" + selectionKeySet.size());
        selectionKeySet.forEach((selectionKey) -> inspect(selectionKey));
    }
}
