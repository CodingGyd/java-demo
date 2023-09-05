package com.gyd.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DelayQueueElement
 * @Description TODO
 * @Author guoyading
 * @Date 2023/7/19 15:41
 * @Version 1.0
 */
public class DelayQueueElement implements Delayed {
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
