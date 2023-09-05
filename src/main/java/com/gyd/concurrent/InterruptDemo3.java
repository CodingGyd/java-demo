package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/4 11:14
 * @Version 1.0
 */
public class InterruptDemo3 {

    public static void main(String[] args) {
       Thread t1= new Thread(()->{
            while(true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName()+" 被中断");
                    break;
                }
                System.out.println("t1 --- hello volatile");
            }
        },"t1");
       t1.start();


        try {
            TimeUnit.MICROSECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            t1.interrupt();
        },"t2").start();
  
    }
}
