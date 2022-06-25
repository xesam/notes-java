package io.github.xesam.lang.lang;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by xe on 15-3-7.
 */
public class ReferenceTest {

    static WeakReference<List> listWeakReference;

    public static void main(String[] args) throws InterruptedException {
        ReferenceTest referenceTest = new ReferenceTest();
//        referenceTest.testSoftReference();
//        referenceTest.testWeakReference();
//        referenceTest.testPhantomReference();


        testSimpleWeakReference();
        while (true){
            System.gc();
            System.out.println(listWeakReference.get() == null);
            TimeUnit.SECONDS.sleep(2);
        }

    }

    static void testSimpleWeakReference(){
        List<String> list = new ArrayList<>();
        listWeakReference = new WeakReference<>(list);
        System.out.println(listWeakReference.get() == null);
    }

    private void testSoftReference() throws InterruptedException {

        Obj obj = new Obj();
        Obj obj1 = obj;

        ReferenceQueue<Obj> q = new ReferenceQueue<>();
        SoftReference<Obj> ref = new SoftReference<>(obj, q);

        while (true) {
            System.gc();
            Thread.sleep(1000);
            if (ref.get() == null) {
                System.out.println("null");
                break;
            } else {
                System.out.println(ref.get());
            }
            if (obj != null) {
                obj = null; // 清除obj的强引用
            } else if (obj1 != null) {
                obj1 = null; //清除obj1的强引用
            }
        }

    }

    private void testWeakReference() throws InterruptedException {

        Obj obj = new Obj();
        Obj obj1 = obj;

        ReferenceQueue<Obj> q = new ReferenceQueue<>();
        WeakReference<Obj> ref = new WeakReference<>(obj, q);

        while (true) {
            System.gc();
            Thread.sleep(1000);
            if (ref.get() == null) {
                System.out.println("null");
                break;
            } else {
                System.out.println(ref.get());
            }
            if (obj != null) {
                obj = null; // 清除obj的强引用
            } else if (obj1 != null) {
                obj1 = null; //清除obj1的强引用
            }
        }
    }

    private void testPhantomReference() throws InterruptedException {

        Obj obj = new Obj();
        Obj obj1 = obj;

        ReferenceQueue<Obj> q = new ReferenceQueue<>();
        PhantomReference<Obj> ref = new PhantomReference<>(obj, q);

        while (true) {
            Thread.sleep(1000);
            if (obj != null) {
                System.out.println(obj);
                obj = null; // 清除obj的强引用
            } else if (obj1 != null) {
                System.out.println(obj1);
                obj1 = null; //清除obj1的强引用
            }

            boolean b = false;

            for (Object x; (x = q.poll()) != null; ) {
                if (x == null) {
                    System.out.println("x == null");
                } else {
                    System.out.println("x != null");
                    b = true;
                }
            }

            if (b) {
                break;
            }

            System.gc();
        }
    }

    private static class Obj {
        @Override
        public String toString() {
            return "obj";
        }

        @Override
        protected void finalize() throws Throwable {
            //可以在这里在添加一个强引用,那么对象就不会被回收了
            System.out.println("finalize");
        }
    }

}
