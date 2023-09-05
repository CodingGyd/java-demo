package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/4 11:14
 * @Version 1.0
 */
public class InterruptDemo1 {
    static volatile boolean isStop = false;
    public static void main(String[] args) {
        new Thread(()->{
            while(true) {
                if (isStop) {
                    System.out.println(Thread.currentThread().getName()+" 被中断");
                    break;
                }
                System.out.println("t1 --- hello volatile");
            }
        },"t1").start();


        try {
            TimeUnit.MICROSECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            isStop = true;
        },"t2").start();

    }
}
