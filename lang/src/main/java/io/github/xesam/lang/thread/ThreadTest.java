package io.github.xesam.lang.thread;

/**
 * Created by xe on 15-2-10.
 */
public class ThreadTest {

    public static void main(String[] args) {
        LockObj lockObj = new LockObj();
        Task1 task1 = new Task1(lockObj);
        Task2 task2 = new Task2(lockObj);
        task1.start();
        task2.start();
    }

    static class LockObj {

        Object object1 = new Object();
        Object object2 = new Object();

        synchronized public static void static_fn_1() {
            System.out.println("static_fn_1 start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("static_fn_1 end");
        }

        synchronized public static void static_fn_2() {
            System.out.println("static_fn_2 start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("static_fn_2 end");
        }

        public void fn_1() {
            synchronized (object1) {
                System.out.println("fn_1 start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("fn_1 end");
            }
        }

        public void fn_2() {
            synchronized (object2) {
                System.out.println("fn_2 start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("fn_2 end");
            }
        }

        public void fn_3() {
            System.out.println("fn_3 enter");
            synchronized (this) {
                System.out.println("fn_3 start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("fn_3 end");
            }
        }

        public void fn_4() {
            System.out.println("fn_4 enter");
            synchronized (this) {
                System.out.println("fn_4 start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("fn_4 end");
            }
        }
    }


    static class Task1 extends Thread {
        private LockObj lockObj;

        public Task1(LockObj lockObj) {
            this.lockObj = lockObj;
        }

        @Override
        public void run() {
            lockObj.fn_3();
        }
    }

    static class Task2 extends Thread {
        private LockObj lockObj;

        public Task2(LockObj lockObj) {
            this.lockObj = lockObj;
        }

        @Override
        public void run() {
            lockObj.fn_4();
        }
    }

}
