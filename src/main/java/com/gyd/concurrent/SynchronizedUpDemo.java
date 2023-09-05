package com.gyd.concurrent;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizedUpDemo {
    public static void main(String[] args) {
        Object object = new Object();
        object.hashCode();
        System.out.println("10进制："+object.hashCode());
        System.out.println("16进制："+Integer.toHexString(object.hashCode()));
        System.out.println("2进制："+Integer.toBinaryString(object.hashCode()));

        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }

}
