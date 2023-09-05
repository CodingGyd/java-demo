package com.gyd.concurrent;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureDemo2 {
    //先A后B的场景应用
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //推荐配置自定义的线程池！！
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
                //第一步
                int result = new Random().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 出结果:" + result);
                return result;
            },executorService).whenComplete((v, e) -> {
                //第二步，获取第一步的结果
                if (null == e) {
                    System.out.println(Thread.currentThread().getName() + " 接收到结果:" + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("发生异常了：" + e);
                return null;
            });

            System.out.println(Thread.currentThread().getName()+"主线程去忙别的事情");
            //主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭，这里暂停3秒钟
            try{ Thread.sleep(3000);}catch (Exception e){e.printStackTrace();}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
