package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockSupportDemo1
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/8 18:49
 * @Version 1.0
 */
public class LockSupportDemo3 {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" enter");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+" 被唤醒");
        },"AAA");
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            LockSupport.unpark(thread);
            System.out.println(Thread.currentThread().getName()+" 发起唤醒");

        },"BBB").start();
    }
}
