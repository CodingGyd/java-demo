package com.gyd.concurrent;

import java.util.concurrent.*;

//8种锁情况
//1.两个实例同步方法 同一个实例
//2.两个实例同步方法 两个实例
//3.两个静态同步方法 同一个实例
//4.两个静态同步方法 两个实例
//5.一个实例同步方法，一个静态同步方法 同一个实例
//6.一个实例同步方法，一个静态同步方法 两个实例
//7.一个实例同步方法，一个实例非同步方法， 同一个实例
//8.一个实例同步方法，一个
class Phone {
    public synchronized void printA(){
        try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {throw new RuntimeException(e);}
        System.out.println("AAAAAA");
    }

    public static synchronized void printB(){
        System.out.println("BBBBB");
    }

    public void printC(){
        System.out.println("CCCCC");
    }

    public void printD(){
        synchronized(this){
            System.out.println("CCCCC");
        }
    }
}
public class LockDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Phone a = new Phone();
        Phone b = new Phone();

        new Thread(() -> {
            a.printA();

        }).start();
        //保证a线程先启动
        Thread.sleep(200);
        new Thread(() -> {
            b.printB();
        }).start();
    }
//结论 ：
    //锁加在实例方法上，锁的是单个实例内范围的操作
    //锁加在静态方法上，锁的是类范围的操作，所有实例都会受影响
}
