package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName LockSupportDemo1
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/8 18:49
 * @Version 1.0
 */
public class LockSupportDemo1 {

    private static Object lockObject = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (lockObject) {
                System.out.println(Thread.currentThread().getName()+" enter");
                try {
                    lockObject.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" 被唤醒");

            }
        },"AAA").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            synchronized (lockObject) {
                lockObject.notify();
                System.out.println(Thread.currentThread().getName()+" 发出唤醒通知");
            }
        },"BBB").start();
    }
}
