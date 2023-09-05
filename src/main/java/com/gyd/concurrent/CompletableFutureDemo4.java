package com.gyd.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "abc";
        });

        //不见不散
//        System.out.println(completableFuture.get());
        //过时不候（抛出TimeoutException）
//        System.out.println(completableFuture.get(2,TimeUnit.SECONDS));
        //立即返回(立即获取结果不阻塞，没有计算完成的情况 给一个默认值)
//        System.out.println(completableFuture.getNow("xxx"));

        //complete方法用于判断是否执行完成，未执行完成则返回默认值，注意该方法只能被执行一次
        TimeUnit.SECONDS.sleep(4);
        System.out.println(completableFuture.complete("completeValue")+" "+completableFuture.join());

    }
}
