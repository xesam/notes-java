package io.github.xesam.lang.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xe on 15-2-12.
 */
public class BlockingQueueMock {
    public static void main(String[] args) {

        final MockBlockingQueue mockBlockingQueue = new MockBlockingQueue();

        //read
        new Thread(() -> {
            while (true) {
                try {
                    int e = mockBlockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + ",take:" + e);
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        }).start();

        //write
        new Producer(mockBlockingQueue, 1000).start();
        new Producer(mockBlockingQueue, 2000).start();
        new Producer(mockBlockingQueue, 3000).start();
    }

    public static class Producer extends Thread {
        MockBlockingQueue mockBlockingQueue;
        long time;

        public Producer(MockBlockingQueue mockBlockingQueue, long time) {
            this.mockBlockingQueue = mockBlockingQueue;
            this.time = time;
        }

        @Override
        public void run() {
            int count = 0;
            while (true) {
                try {
                    int e = (count++);
                    mockBlockingQueue.put(e);
                    System.out.println(getName() + ",put:" + e);
                    Thread.sleep(time);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static class MockBlockingQueue {

        private List<Integer> queue;

        private ReentrantLock lock;
        private Condition notEmpty; //read
        private Condition notFull; //write

        public MockBlockingQueue() {
            queue = new LinkedList<>();
            lock = new ReentrantLock();
            notEmpty = lock.newCondition();
            notFull = lock.newCondition();
        }

        public Integer take() throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    notFull.await();
                }
                notEmpty.signalAll();
                return queue.remove(0);
            } finally {
                lock.unlock();
            }
        }

        public void put(Integer e) throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == 3) {
                    notEmpty.await();
                }
                notFull.signalAll();
                queue.add(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
