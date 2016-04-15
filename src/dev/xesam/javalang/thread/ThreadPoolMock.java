package dev.xesam.javalang.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xe on 2014/9/19.
 * xesamguo@gmail.com
 */
public class ThreadPoolMock extends ThreadGroup {

    private static String Tag = "ThreadPoolMock";
    private WordThread[] wordThreads;
    private Queue<Runnable> taskQueue;
    private volatile int taskQueueIndex = 0;

    public ThreadPoolMock(int size) {
        super(Tag);
        setDaemon(true);
        taskQueue = new LinkedList<Runnable>();
        wordThreads = new WordThread[size];
        for (int i = 0; i < size; ++i) {
            wordThreads[i] = new WordThread(this, i);
            wordThreads[i].start();
        }
    }

    public static void main(String[] args) {

        class MockTask implements Runnable {
            int i;

            private MockTask(int i) {
                this.i = i;
            }

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        ThreadPoolMock threadPoolMock = new ThreadPoolMock(5);

        for (int i = 0; i < 100; ++i) {
            MockTask mockTask = new MockTask(i);
            threadPoolMock.execute(mockTask);
        }
    }

    public synchronized void execute(Runnable runnable) {
        taskQueue.add(runnable);
        notify();
    }

    private synchronized Runnable nextTask() throws InterruptedException {
        if (taskQueue.size() == 0) {
            wait();
        }
        return taskQueue.poll();
    }

    private class WordThread extends Thread {

        public WordThread(ThreadGroup threadGroup, int id) {
            super(threadGroup, id + "");
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                Runnable runnable = null;
                try {
                    runnable = nextTask();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (null != runnable) {
                    runnable.run();
                }
            }
        }
    }
}
