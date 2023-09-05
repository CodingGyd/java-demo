package com.gyd.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @ClassName AtomicLongTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/2 13:45
 * @Version 1.0
 */
public class AtomicLongArrayTest {
    static AtomicLongArray al = new AtomicLongArray(1);

    public static void main(String[] args) {
        long[] array = new long[]{1,2};
        //注意这里构造方法内部是对array引用进行一个拷贝，之后的修改不会影响到原先的引用
        AtomicLongArray al = new AtomicLongArray(array);
 		System.out.println(al.addAndGet(0,10));
        System.out.println(al.compareAndSet(0,11,15));
        System.out.println(al.get(0));
    }
}
