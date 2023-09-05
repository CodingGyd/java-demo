package com.gyd.concurrent;

import java.util.concurrent.*;

public class CompletableFutureDemo10 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

       CompletableFuture<String> playA = CompletableFuture.supplyAsync(() ->{
           try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {throw new RuntimeException(e);}
            return "playA";
       });

        CompletableFuture<String> playB = CompletableFuture.supplyAsync(() ->{
            try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {throw new RuntimeException(e);}
            return "playB";
        });
        CompletableFuture<String> winer = playA.applyToEither(playB,f -> f+" is winer");
        System.out.println(Thread.currentThread().getName()+"\t"+"-----:" + winer.join());
     }

}
