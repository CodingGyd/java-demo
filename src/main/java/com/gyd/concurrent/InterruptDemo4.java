
package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/4 11:14
 * @Version 1.0
 */
public class InterruptDemo4 {

    public static void main(String[] args) {
       System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
       System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
       System.out.println("===1");
       Thread.currentThread().interrupt();
       System.out.println("===2");
       System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
       System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
    }
}
