#Thread

线程不是语言概念，是操作系统的概念。

##线程的状态 Thread.State

1. NEW

    创建了一个线程对象,但是还未start

2. RUNNABLE

    线程正在运行

3. BLOCKED

    等待进入同步块(monitor lock),注意与Lock对象的区别

4. WAITING

    等待其他线程的操作,触发进入此状态是操作:

        Object.wait with no timeout
        Thread.join with no timeout
        LockSupport.park //比如condition.await()

5. TIMED_WAITING

    等待一定的时间

        Thread.sleep
        Object.wait with timeout
        Thread.join with timeout
        LockSupport.parkNanos
        LockSupport.parkUntil


6. TERMINATED

    线程已经终止


Thread1.java //打印6中状态