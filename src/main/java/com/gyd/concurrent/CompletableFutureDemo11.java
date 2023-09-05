package com.gyd.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo11 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

       CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
           try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {throw new RuntimeException(e);}
            return "task1";
       });
       CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {throw new RuntimeException(e);}
            return "task2";
        });
        CompletableFuture<String> future3 = future1.thenCombine(future2, (x , y) -> {
            return "合并："+x+y;
        });
        System.out.println(future3.join());
     }

}
