package com.gyd.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo8 {

    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args){
        new Thread(()->{
            //可重入锁示例-同步方法
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+" 外层调用");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+" 内层调用");
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }

        }).start();
    }

}
