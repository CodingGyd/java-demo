package com.gyd.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/4 11:14
 * @Version 1.0
 */
//资源类，模拟30元
class Money {
    private int number = 30;

    ReentrantLock lock = new ReentrantLock(true);
    public void get(){
        lock.lock();

        try {
            if (number>0) {
                number--;
                System.out.println(Thread.currentThread().getName()+" 获得1元,当前还剩"+number+"元");
            }
        }finally {
            lock.unlock();
        }
    }
}
public class LockDemo6 {

    public static void main(String[] args) {
        Money money = new Money();
        new Thread(()->{for (int i=0;i<50;i++) {money.get();}},"a").start();
        new Thread(()->{for (int i=0;i<50;i++) {money.get();}},"b").start();
        new Thread(()->{for (int i=0;i<50;i++) {money.get();}},"c").start();
    }
}
