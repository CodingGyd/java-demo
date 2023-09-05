package com.gyd.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName AtomicLongTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/2 13:45
 * @Version 1.0
 */
public class AtomicLongTest {
    static AtomicLong al = new AtomicLong(1);

    public static void main(String[] args) {
		System.out.println(al.getAndSet(2));
        System.out.println(al.compareAndSet(2,3));
        al.lazySet(4);
        System.out.println(al.get());
    }
}
