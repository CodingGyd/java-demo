package com.gyd.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/2 16:12
 * @Version 1.0
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(()->{
            System.out.println("a线程到达屏障点,开始阻塞");
            try {cyclicBarrier.await();} catch (Exception e) {}
            System.out.println("屏障开门了，a线程继续执行");
        }).start();

        new Thread(()->{
            System.out.println("b线程到达屏障点,开始阻塞");
            try {cyclicBarrier.await();} catch (Exception e) {}
            System.out.println("屏障开门了，b线程继续执行");
        }).start();

        Thread.sleep(10000);
    }
}
