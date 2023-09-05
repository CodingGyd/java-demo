package com.gyd.concurrent;

import java.util.concurrent.*;

/**
 * @ClassName QueueDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/19 15:37
 * @Version 1.0
 */
public class QueueDemo {
    public static void main(String[] args) {
        //1.用数组实现的有界阻塞队列(支持公平和非公平锁)
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1000,false);
        //2.用链表实现的有界阻塞队列(保证FIFO先进先出)
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1000);
        //3.支持优先级的无界阻塞队列。不设置排序策略情况下元素采取的是自然顺序升序排列
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(1000);
		//4.支持延时获取元素的无界阻塞队列(队列中的元素必须实现 Delayed 接口,参考ScheduledThreadPoolExecutor 里 ScheduledFutureTask 类的实现)
        DelayQueue delayQueue = new DelayQueue();
        //5.不存储元素的阻塞队列。每一个 put 操作必须等待一个take 操作，否则不能继续添加元素(支持公平和非公平锁)
        SynchronousQueue synchronousQueue = new SynchronousQueue(true);
		//6.是一个由链表结构组成的无界阻塞 TransferQueue 队列。相对于其他阻塞队列，LinkedTransferQueue 多了 tryTransfer 和 transfer 方法。
        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();
		//7.由链表结构组成的双向阻塞队列。所谓双向队列指的是可以从队列的两端插入和移出元素
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();



    }
}
