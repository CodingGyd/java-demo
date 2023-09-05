package com.gyd.concurrent;

/**
 * @ClassName VolatileDemo3
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/5 15:51
 * @Version 1.0
 */
public class VolatileDemo3 {

    private volatile static VolatileDemo3 instance;

    private VolatileDemo3(){}

    public static VolatileDemo3 getInstance(){

        //第一次检测
        if (instance==null){
            //同步
            synchronized (VolatileDemo3.class){
                if (instance == null){
                    //多线程环境下可能会出现问题的地方
                    instance = new VolatileDemo3();
                }
            }
        }
        return instance;
    }
}