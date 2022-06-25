package io.github.xesam.lang.concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xe on 15-2-12.
 */
public class ConditionTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        new ThreadA(reentrantLock, condition).start();

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new ThreadB(reentrantLock, condition).start();
                timer.cancel();//结束整个程序
            }
        }, 1000);
    }

    private static class ThreadA extends Thread {

        final ReentrantLock reentrantLock;
        final Condition condition;

        public ThreadA(ReentrantLock reentrantLock, Condition condition) {
            this.reentrantLock = reentrantLock;
            this.condition = condition;
        }

        @Override
        public void run() {
            reentrantLock.lock();
            System.out.println("等待信号");
            try {
                condition.await();
                System.out.println("拿到信号");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static class ThreadB extends Thread {

        final ReentrantLock reentrantLock;
        final Condition condition;

        public ThreadB(ReentrantLock reentrantLock, Condition condition) {
            this.reentrantLock = reentrantLock;
            this.condition = condition;
        }

        @Override
        public void run() {
            reentrantLock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("发送信号");
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
