package com.gyd.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/2 16:24
 * @Version 1.0
 */
public class SemaphoreTest {
    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("预约1位");
                    semaphore.release();
                } catch (InterruptedException e) {
                }
            }).start();
        }

        System.out.println("end");

    }
}
