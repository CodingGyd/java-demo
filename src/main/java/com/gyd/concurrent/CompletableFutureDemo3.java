package com.gyd.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureDemo3 {
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("taobao"));

    //串行版本
    public static List<String> getPrice(List<NetMall> list,String productName) {
       return list.stream()
                  .map(netMall ->
                          String.format(productName+" in %s price is %.2f",
                                  netMall.getNetMallName(),
                                  netMall.calPrice(productName)))
                  .collect(Collectors.toList());
    }

    //并行版本
    public static List<String> getPriceByCompletableFuture(List<NetMall> list,String productName) {
        return list.stream().map(netMall -> CompletableFuture.supplyAsync(() ->
                        String.format(productName+"in %s price is %.2f",netMall.getNetMallName(),netMall.calPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(s -> s.join())
                .collect(Collectors.toList());

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       long startTime = System.currentTimeMillis();
       List<String> list1 = getPrice(list,"mysql");
       for (String element : list1) {
           System.out.println(element);
       }
       long endTime = System.currentTimeMillis()-startTime;
       System.out.println("costTime:"+endTime);

       System.out.println("=======================");
       startTime = System.currentTimeMillis();
       List<String> list2 = getPriceByCompletableFuture(list,"mysql");
       for (String element : list2) {
           System.out.println(element);
       }
       endTime = System.currentTimeMillis()-startTime;
       System.out.println("======costTime2 "+endTime);
    }
}

class NetMall {
    String netMallName;

    public String getNetMallName() {
        return netMallName;
    }

    public NetMall(String netMallName){this.netMallName = netMallName;}

    public Double calPrice(String productName){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble()*2+productName.charAt(0);
    }

}
