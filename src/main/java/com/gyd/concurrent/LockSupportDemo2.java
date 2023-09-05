package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockSupportDemo1
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/8 18:49
 * @Version 1.0
 */
public class LockSupportDemo2 {


    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+" enter");
                condition.await();
                System.out.println(Thread.currentThread().getName()+" 被唤醒");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        },"AAA").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName()+" 发起唤醒");
            } finally {
                lock.unlock();
            }
        },"BBB").start();
    }
}
