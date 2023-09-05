package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName AqsDemo1
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/1 10:32
 * @Version 1.0
 */
public class AqsDemo1 extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        return compareAndSetState(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return compareAndSetState(1, 0);
    }

    public static void main(String[] args) throws InterruptedException {
        final AqsDemo1 lock = new AqsDemo1();

        new Thread(() -> {
            System.out.println("thread1 acquire lock");
            lock.acquire(1);
            // 获取资源后sleep保持
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch(InterruptedException ignore) {

            }
            lock.release(1);
            System.out.println("thread1 release lock");
        }).start();

        new Thread(() -> {
            // 保证线程2在线程1启动后执行
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException ignore) {

            }
            // 等待线程1 sleep结束释放资源
            lock.acquire(1);
            System.out.println("thread2 acquire lock");
            lock.release(1);
        }).start();

    }

}
