package com.gyd.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/4 11:14
 * @Version 1.0
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {

        TimeRecorder timeRecorder = new TimeRecorder();
        timeRecorder.begin();
        TimeUnit.SECONDS.sleep(1);

        timeRecorder.end();

        new Thread(()->{
            TimeRecorder r = new TimeRecorder();
            r.begin();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i=0;i<100000000;i++) {
            }
            r.end();
        }).start();

    }


}
class TimeRecorder {
    private static final ThreadLocal<Long> time = new ThreadLocal<>();

    public void begin() {
        time.set(System.currentTimeMillis());
    }

    public void end() {
        long t = System.currentTimeMillis()-time.get();
        System.out.println(Thread.currentThread().getName()+" 耗时："+t);
    }
}