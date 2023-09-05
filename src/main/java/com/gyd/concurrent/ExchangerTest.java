package com.gyd.concurrent;

import java.util.concurrent.Exchanger;

/**
 * @ClassName ExchangerTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/2 16:36
 * @Version 1.0
 */
public class ExchangerTest {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(()->{
            try {
                String bResult = exchanger.exchange("hello B");
                System.out.println("A thread: get B thread Result is "+bResult);
            } catch (InterruptedException e) {}
        }).start();

        new Thread(()->{
            try {
                String aResult = exchanger.exchange("hello A");
                System.out.println("B thread: get A thread Result is "+aResult);
            } catch (InterruptedException e) {}
        }).start();

        Thread.sleep(100);
    }
}
