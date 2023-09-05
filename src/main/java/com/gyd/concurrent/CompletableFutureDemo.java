package com.gyd.concurrent;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("======CompletableFuture.runAsync的演示(无返回值，默认线程池)");
        runAsync1();
        System.out.println("======CompletableFuture.runAsync的演示(无返回值，自定义线程池)");
        runAsync2();
        System.out.println("======CompletableFuture.supplyAsync1的演示(有返回值，默认线程池)");
        supplyAsync1();
        System.out.println("======CompletableFuture.supplyAsync1的演示(有返回值，自定义线程池)");
        supplyAsync2();
    }

    public static void runAsync1() throws ExecutionException, InterruptedException {
        //不推荐
        //CompletableFuture completableFuture = new CompletableFuture();
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
           System.out.println(Thread.currentThread().getName());
           try {TimeUnit.SECONDS.sleep(1);}catch (Exception e) {e.printStackTrace();}
        });
        System.out.println(completableFuture.get());
    }

    public static void runAsync2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try {TimeUnit.SECONDS.sleep(1);}catch (Exception e) {e.printStackTrace();}
        },executorService);
        System.out.println(completableFuture.get());
        executorService.shutdown();
    }

    public static void supplyAsync1() throws ExecutionException, InterruptedException {
         CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->{
             System.out.println(Thread.currentThread().getName());
             try {TimeUnit.SECONDS.sleep(1);}catch (Exception e) {e.printStackTrace();}
             return "Hello Supply";
         });
         System.out.println(completableFuture.get());
    }
    public static void supplyAsync2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println(Thread.currentThread().getName());
            try {TimeUnit.SECONDS.sleep(1);}catch (Exception e) {e.printStackTrace();}
            return "Hello Supply";
        },executorService);
        System.out.println(completableFuture.get());
        executorService.shutdown();
    }
}
