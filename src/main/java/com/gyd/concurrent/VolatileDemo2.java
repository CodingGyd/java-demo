package com.gyd.concurrent;

/**
 * @ClassName VolatileDemo1
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/4 11:14
 * @Version 1.0
 */
public class VolatileDemo2 {
    private volatile static boolean flag = false;

    public static class PhoneThread extends Thread {
        @Override
        public void run() {
            System.out.println("PhoneThread is running...");
            while (!flag) ; // 如果flag为false，则死循环
            System.out.println("PhoneThread is end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new PhoneThread().start();
        Thread.sleep(1000);
        flag = true;
        System.out.println("flag = " + flag);
        Thread.sleep(5000);
        System.out.println("main thread is end.");
    }
}
