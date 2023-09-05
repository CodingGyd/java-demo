package com.gyd.atomic;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class BankCard{
    private String name;
    private Integer money;

    public BankCard(String name,Integer money) {
        this.money = money;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
public class AtomicDemo2 {

    private static volatile  BankCard bankCard = new BankCard("张三",100);
    private static AtomicReference<BankCard> bankCard2 = new AtomicReference<>(new BankCard("张三",100));

    public static void main(String[] args) {

        //线程不安全版本
//        putMoney();

        //线程安全版本1 使用锁 synchronized
//        putMoneySafe1();

        //线程安全版本2 使用锁 AtomicReference
        putMoneySafe2();

    }

    //线程不安全版本
    private static void putMoney(){
        for (int i=0;i<10;i++) {
            new Thread(()->{
                //构造一个新的账户，存入100元
                BankCard newBankCard = new BankCard(bankCard.getName(),bankCard.getMoney()+100);

                System.out.println(Thread.currentThread().getName()+" "+ newBankCard);
                //把新的账户引用赋给原账户
                bankCard = newBankCard;
                try {TimeUnit.MICROSECONDS.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}

            }).start();
        }
    }

    //线程安全版本1 使用锁 synchronized
    private static void putMoneySafe1(){
        for (int i=0;i<10;i++) {
            new Thread(()->{
                synchronized (AtomicDemo2.class) {
                    //构造一个新的账户，存入100元
                    BankCard newBankCard = new BankCard(bankCard.getName(), bankCard.getMoney() + 100);

                    System.out.println(Thread.currentThread().getName() + " " + newBankCard);
                    //把新的账户引用赋给原账户
                    bankCard = newBankCard;
                    try {
                        TimeUnit.MICROSECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }

    //线程安全版本2 使用锁 AtomicReference
    private static void putMoneySafe2(){
        for (int i=0;i<10;i++) {
            new Thread(()->{
                    while(true) {
                        BankCard oldBankCard = bankCard2.get();
                        //构造一个新的账户，存入100元
                        BankCard newBankCard = new BankCard(oldBankCard.getName(), oldBankCard.getMoney() + 100);

                        //把新的账户引用赋给原账户
                        if(bankCard2.compareAndSet(oldBankCard,newBankCard)){
                            System.out.println(Thread.currentThread().getName() + " " + newBankCard);
                            break;
                        }
                        try {
                            TimeUnit.MICROSECONDS.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

            }).start();
        }
    }
}
