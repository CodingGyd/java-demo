package com.gyd.concurrent;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/4 11:14
 * @Version 1.0
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    private void deadLockTest() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("1");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A){
                    System.out.println("2");
                }
            }
        });
        t1.start();
        t2.start();
    }
    public static void main(String[] args) {
        new DeadLockDemo().deadLockTest();
    }
}
