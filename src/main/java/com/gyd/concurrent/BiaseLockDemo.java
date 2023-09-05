package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName BiaseLockDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/11 21:13
 * @Version 1.0
 */
public class BiaseLockDemo {
    private int number = 30;

    Object lock = new Object();

    public void require(){
        synchronized (lock){
            if (number > 0) {
                System.out.println(Thread.currentThread().getName()+" 抢到一个令牌");
                number--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BiaseLockDemo biaseLockDemo = new BiaseLockDemo();
        new Thread(()->{for (int i=0;i<30;i++) {biaseLockDemo.require();}}).start();
        new Thread(()->{for (int i=0;i<30;i++) {biaseLockDemo.require();}}).start();
        new Thread(()->{for (int i=0;i<30;i++) {biaseLockDemo.require();}}).start();
        TimeUnit.SECONDS.sleep(5);
    }

}
