package com.gyd.concurrent;

import java.util.Map;
import java.util.concurrent.*;

public class CompletableFutureDemo12 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Map<String,Object> orderMap = new ConcurrentHashMap<>();
       CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
           try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {throw new RuntimeException(e);}
           System.out.println("获取地址信息...");
           orderMap.put("address","湖南");
            return "task1";
       });
       CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {throw new RuntimeException(e);}
           System.out.println("获取支付信息...");
           orderMap.put("payinfo","10元");
           return "task2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() ->{
            try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("获取商品信息...");
            orderMap.put("goods","袜子");
            return "task3";
        });
        CompletableFuture<Void> result = CompletableFuture.allOf(future1,future2,future3);
        result.join();

        System.out.println("完整的订单数据:"+orderMap.toString());
     }

}
