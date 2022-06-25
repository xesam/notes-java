package io.github.xesam.lang.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by xe on 16-5-31.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        try {
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
