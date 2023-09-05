package com.gyd.concurrent;

public class LockDemo2 {

    Object object = new Object();
    public void m1(){
        synchronized (object) {
            System.out.println("----hello");
        }
        System.out.println("-other code---");
    }
    public static void main(String[] args){
    }
}
