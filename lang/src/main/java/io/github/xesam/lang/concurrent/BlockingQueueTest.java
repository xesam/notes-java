package io.github.xesam.lang.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xe on 15-2-6.
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        basic();
    }

    static void basic() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.remainingCapacity());
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        System.out.println(blockingQueue.remainingCapacity());
//        blockingQueue.add("d"); //java.lang.IllegalStateException: Queue full

        BlockingQueue<String> blockingQueueBak = new ArrayBlockingQueue(3);
        blockingQueue.drainTo(blockingQueueBak);
        System.out.println(blockingQueue.size());
        System.out.println(blockingQueueBak.size());
    }

    static void produceConsume() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(blockingQueue);
            new Thread(producer).start();
        }
        new Thread(new Consumer(blockingQueue)).start();
    }

    static class Producer implements Runnable {

        static final AtomicInteger counter = new AtomicInteger();
        private BlockingQueue<String> blockingQueue;
        private int order;

        public Producer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.order = counter.incrementAndGet();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String s = blockingQueue.take();
                    System.out.println(order + " Producer:" + s);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        static final AtomicInteger counter = new AtomicInteger();
        private BlockingQueue<String> blockingQueue;
        private int order;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.order = counter.incrementAndGet();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    blockingQueue.put("a");
                    System.out.println(order + " Consumer");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
