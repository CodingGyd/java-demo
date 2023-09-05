package com.gyd.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;
    public static void main(String[] args)  {
        AtomicDemo atomicDemo = new AtomicDemo();
        List<Thread> allThread = new ArrayList<>(100);
        long start = System.currentTimeMillis();
        for(int i=1;i<=100;i++) {
            Thread t = new Thread(() ->{
                for (int j=0;j<1000;j++) {
                    atomicDemo.count();
                    atomicDemo.safeCount();
                }
            });
            allThread.add(t);
        }
        for (Thread t : allThread) {
            t.start();
        }

        //等待所有线程执行完成
        for (Thread t: allThread){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(atomicDemo.i);
        System.out.println(atomicDemo.atomicInteger.get());
        System.out.println(System.currentTimeMillis()-start);

    }

    private void count(){
        i++;
    }

    private void safeCount() {
        for (;;) {
            int a = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(a,++a);
            if (suc) break;
        }

    }

}
