package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName InterruptDemo5
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/10 17:00
 * @Version 1.0
 */
public class InterruptDemo5 {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() ->{
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " 我被唤醒啦！！！");
        },"a");
        a.start();
         TimeUnit.SECONDS.sleep(1);

        new Thread(()-> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName()+" 我把a唤醒一下");
        },"B").start();
    }

}