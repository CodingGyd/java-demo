package com.gyd.concurrent;

public class LockDemo4 {
    public synchronized void m1(){
        System.out.println("----实例同步方法");
    }

    public void m2(){
        System.out.println("----普通方法");
     }
    public static void main(String[] args){
    }
}
