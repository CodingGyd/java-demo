package com.gyd.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        //one线程
        new Thread(()->{
            System.out.println("one");
            countDownLatch.countDown();
        }).start();

        //two线程
        new Thread(()->{
            System.out.println("two");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        //main线程
        System.out.println("main");
    }
}

