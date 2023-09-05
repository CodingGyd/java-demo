package com.gyd.concurrent;

import java.util.concurrent.*;

public class CompletableFutureDemo7 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("111");
            return 1;
        },executorService).thenApply(f ->{
            System.out.println("222");
            return f+2;
        }).thenApply(f->{
            return f+3;
        }).thenAccept(f -> {
            //接受任务的计算结果，进行消费处理，无返回结果
            System.out.println("完成前两个步骤的任务，消费结果="+f);
        });
        executorService.shutdown();
    }


}
