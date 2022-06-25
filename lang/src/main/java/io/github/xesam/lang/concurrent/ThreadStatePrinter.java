package io.github.xesam.lang.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xe on 15-2-13.
 */
public class ThreadStatePrinter {

    static final Object obj = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread slaveThread = new Thread("slaveThread") {
            @Override
            public void run() {
                log(2, this);//slaveThread#RUNNABLE
                lock.lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                synchronized (obj) {
                    try {
                        obj.wait(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.lock();
                condition.signalAll();
                lock.unlock();
            }
        };

        Thread controlThread = new Thread(() -> {
            log(1, slaveThread); //slaveThread#NEW
            slaveThread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log(3, slaveThread); //slaveThread#WAITING
            lock.lock();
            condition.signalAll();
            synchronized (obj) {
                lock.unlock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log(4, slaveThread); //slaveThread#BLOCKED
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log(5, slaveThread); //slaveThread#TIMED_WAITING

            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            log(6, slaveThread); //slaveThread#TERMINATED
        }, "controlThread");

        controlThread.start();
    }

    public static void log(int index, Thread thread) {
        System.out.println(index + ":" + thread.getName() + ":" + thread.getState().toString());
    }


}
