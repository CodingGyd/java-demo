package com.gyd.concurrent;

import java.util.concurrent.*;

public class CompletableFutureDemo9 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        //模拟任务执行速度快的情况，系统底层会使用main线程处理任务
        //运行结果：
        //1号任务	ForkJoinPool.commonPool-worker-25
        //2号任务	ForkJoinPool.commonPool-worker-25
        //3号任务	main
        //4号任务	main
        System.out.println("===模拟任务执行速度快的情况，系统底层会使用main线程处理任务====");
        test0();

         //使用内置默认线程池+thenRun执行任务
        //运行结果：
        //1号任务	ForkJoinPool.commonPool-worker-25
        //2号任务	ForkJoinPool.commonPool-worker-25
        //3号任务	ForkJoinPool.commonPool-worker-25
        //4号任务	ForkJoinPool.commonPool-worker-25
        //null
        System.out.println("===使用内置默认线程池+thenRun执行任务====");
        test1();

         //使用自定义线程池+thenRun执行任务
        //运行结果：
        //1号任务	pool-1-thread-1
        //2号任务	pool-1-thread-1
        //3号任务	pool-1-thread-1
        //4号任务	pool-1-thread-1
        System.out.println("===使用自定义线程池+thenRun执行任务====");
        test2();

         //使用内置默认线程池+thenRunAsync执行任务
        //运行结果：
        //1号任务	ForkJoinPool.commonPool-worker-25
        //2号任务	ForkJoinPool.commonPool-worker-25
        //3号任务	ForkJoinPool.commonPool-worker-25
        //4号任务	ForkJoinPool.commonPool-worker-25
        System.out.println("===使用内置默认线程池+thenRunAsync执行任务====");
        test3();

         //使用自定义线程池+thenRunAsync执行任务
        //运行结果：
        //1号任务	pool-2-thread-1
        //2号任务	ForkJoinPool.commonPool-worker-25
        //3号任务	ForkJoinPool.commonPool-worker-25
        //4号任务	ForkJoinPool.commonPool-worker-25
        System.out.println("===使用自定义线程池+thenRunAsync执行任务====");
        test4();

     }
    /**
     总结：1.没有传入自定义线程池时，都使用默认线程池ForkJoinPool
          2.执行第一个任务时传入了一个自定义线程池 则当使用thenRun执行之后的任务时，都共用同一个自定义线程池
          3.执行第一个任务时传入了一个自定义线程池 则当使用thenRunAsync执行之后的任务时，只有第一个任务使用的自定义线程池，后续任务都使用的是默认ForkJoin线程池
          4.有可能处理太快的时候，由于系统底层优化原则，直接利用main线程处理任务
     */

     //使用内置默认线程池+thenRun执行任务
    private static void test1() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() ->{
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("1号任务"+"\t"+Thread.currentThread().getName());
            return "abcd";
        }).thenRun(() ->{
            try {Thread.sleep(200);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("2号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("3号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("4号任务"+"\t"+Thread.currentThread().getName());
        });

        System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        System.out.println("===============");
    }

    //使用自定义线程池+thenRun执行任务
    private static void test2() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() ->{
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("1号任务"+"\t"+Thread.currentThread().getName());
            return "abcd";
        },executorService).thenRun(() ->{
            try {Thread.sleep(200);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("2号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("3号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("4号任务"+"\t"+Thread.currentThread().getName());
        });

        System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        executorService.shutdown();
        System.out.println("===============");

    }

    //使用内置默认线程池+thenRunAsync执行任务
    private static void test3() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() ->{
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("1号任务"+"\t"+Thread.currentThread().getName());
            return "abcd";
        }).thenRunAsync(() ->{
            try {Thread.sleep(200);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("2号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("3号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("4号任务"+"\t"+Thread.currentThread().getName());
        });

        System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        System.out.println("===============");

    }
    //使用自定义线程池+thenRunAsync执行任务
    private static void test4() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() ->{
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("1号任务"+"\t"+Thread.currentThread().getName());
            return "abcd";
        },executorService).thenRunAsync(() ->{
            try {Thread.sleep(200);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("2号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("3号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("4号任务"+"\t"+Thread.currentThread().getName());
        });

        System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        executorService.shutdown();
        System.out.println("===============");

    }

    //模拟任务执行速度快的情况，系统底层会使用main线程处理任务
    private static void test0() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println("1号任务"+"\t"+Thread.currentThread().getName());
            return "abcd";
        }).thenRun(() ->{
            System.out.println("2号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            System.out.println("3号任务"+"\t"+Thread.currentThread().getName());
        }).thenRun(() -> {
            System.out.println("4号任务"+"\t"+Thread.currentThread().getName());
        });

        System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        System.out.println("===============");
    }
}
