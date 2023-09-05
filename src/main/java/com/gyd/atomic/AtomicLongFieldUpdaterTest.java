package com.gyd.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicLongTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/2 13:45
 * @Version 1.0
 */
public class AtomicLongFieldUpdaterTest {

    public static void main(String[] args) {
        Bean bean = new Bean("AAA",18);
        AtomicLongFieldUpdater<Bean> atomicLongFieldUpdater =  AtomicLongFieldUpdater.
                newUpdater(Bean.class,"age");
        atomicLongFieldUpdater.set(bean,20);
        System.out.println(atomicLongFieldUpdater.get(bean));
    }

    static class Bean{
        String name;
        volatile long age;

        public Bean(String name, long age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getAge() {
            return age;
        }

        public void setAge(long age) {
            this.age = age;
        }
    }
}
