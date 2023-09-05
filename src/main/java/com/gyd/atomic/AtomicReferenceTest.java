package com.gyd.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicLongTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/2 13:45
 * @Version 1.0
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        Bean bean = new Bean("AAA",18);
        AtomicReference<Bean> atomicReference = new AtomicReference<>();
        atomicReference.set(bean);
        atomicReference.compareAndSet(bean,new Bean("BBB",20));
        System.out.println( atomicReference.get().getAge());
        System.out.println( atomicReference.get().getName());
    }

    static class Bean{
        String name;
        int age;

        public Bean(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
