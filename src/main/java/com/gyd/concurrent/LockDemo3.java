package com.gyd.concurrent;

public class LockDemo3 {

    Object object = new Object();
    public void m1(){
        synchronized (object) {
            System.out.println("----hello");
            throw new RuntimeException("error");
        }
    }
    public static void main(String[] args){
    }
}
