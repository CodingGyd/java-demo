package com.gyd.concurrent;

import java.util.concurrent.*;

public class CompletableFutureDemo6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("111");
            return 1;
        },executorService).handle((f,e) ->{
            System.out.println("222");
            //若当前步骤有异常，则携带异常信息继续执行后续步骤
            int i = 10/0;
            return f+2;
        }).handle((f,e)->{
            System.out.println("上一步骤异常信息："+e);
            System.out.println("333");
            return f+3;
        }).whenComplete((v,e) ->{
            if (e == null) System.out.println("v: "+v);
        }).exceptionally( e ->{
            //发生异常时的处理
            e.printStackTrace();
            System.out.println("发生异常");
            return null;
        });

        System.out.println(Thread.currentThread().getName()+"先去忙别的事情");

    }
}
