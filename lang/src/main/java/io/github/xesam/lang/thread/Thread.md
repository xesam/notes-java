#Thread

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


## 线程优先级

    setPriority()

    Thread.MIN_PRIORITY
    Thread.MAX_PRIORITY
    Thread.NORMAL_PRIORITY

setPriority() 可能会影响程序在不同平台的表现，因为不同的平台对不同优先级的线程的处理策略不同。

