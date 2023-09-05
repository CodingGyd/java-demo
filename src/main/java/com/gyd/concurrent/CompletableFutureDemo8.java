package com.gyd.concurrent;

import java.util.concurrent.*;

public class CompletableFutureDemo8 {

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
        }).thenRun(() ->{
            System.out.println("执行完前两个步骤后，继续执行当前步骤");
        });

        executorService.shutdown();
     }

    
}
