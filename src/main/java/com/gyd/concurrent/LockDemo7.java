package com.gyd.concurrent;

public class LockDemo7 {

    public static void main(String[] args){
        LockDemo7 lockDemo7 = new LockDemo7();
        new Thread(()->{
            //隐式可重入锁示例-同步方法
            lockDemo7.m1();
        }).start();
    }

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName()+" come in");
        m2();
        System.out.println(Thread.currentThread().getName()+"end m1");
    }
    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName()+" come in");
    }
}
