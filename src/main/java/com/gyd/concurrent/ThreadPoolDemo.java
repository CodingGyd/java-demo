package com.gyd.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName ThreadPoolDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/11 17:14
 * @Version 1.0
 */
public class ThreadPoolDemo<T> implements ThreadPool<T> {
    // 线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    // 线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最小的数量
    private static final int MIN_WORKER_NUMBERS = 1;

    //工作任务队列，用户不断提交任务到队列中
    private final LinkedList<T> jobs = new LinkedList<>();

    //工作线程，从任务队列拉取任务进行处理
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());

    // 工作者线程的数量
    private int workerNum = 10;
    // 线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public ThreadPoolDemo() {
        initializeWokers(DEFAULT_WORKER_NUMBERS);
    }
    public ThreadPoolDemo(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : Math.max(num,
                MIN_WORKER_NUMBERS);
        initializeWokers(workerNum);
    }
    public int getJobSize() {
        return jobs.size();
    }
    public void execute(T job) {
        if (null != job) {
            synchronized (jobs) {
                //添加一个任务
                jobs.addLast(job);
                //随机唤醒一个线程
                jobs.notify();
            }
        }
    }

    public void shutdown(){
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    public void initializeWokers(int num){
        for(int i=0;i<num;i++) {
            Worker worker = new Worker();
            workers.add(worker);

            Thread thread = new Thread(worker,"thread-"+threadNum.incrementAndGet());
            thread.start();
        }
    }

    public void addWorkers(int num) {
        synchronized (jobs) {
            // 限制新增的 Worker 数量不能超过最大值
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWokers(num);
            this.workerNum += num;
        }
    }
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num >= this.workerNum) {
                throw new IllegalArgumentException("beyond workNum");
            }
            // 按照给定的数量停止 Worker
            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                if (workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= count;
        }
    }
    //工作线程定义
    class Worker implements Runnable{
        private volatile boolean running = true;
        @Override
        public void run() {
            while(running){
                T job = null;

                synchronized (jobs) {
                    while(jobs.isEmpty()) {
                        try {
                            //等待被唤醒
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部对 WorkerThread 的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                        job = jobs.removeFirst();
                    }
                }
                if (null != job) {
                    System.out.println(Thread.currentThread().getName()+" 执行一个任务======="+job);
                }
            }
            System.out.println(Thread.currentThread().getName()+" 销毁了");

        }

        public void shutdown() {
            running = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        for (int i=0;i<10;i++) {
            BeanDemo beanDemo = new BeanDemo();
            beanDemo.setName("zzz"+i);
            threadPoolDemo.execute(beanDemo);
        }
        TimeUnit.SECONDS.sleep(2);
        threadPoolDemo.shutdown();
    }
}
 class BeanDemo {
    Integer id;
    String name;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }
 }


