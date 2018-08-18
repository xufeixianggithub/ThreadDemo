package com.xufx.ThreadPool.ScheduledThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(2);

        for(int i=0;i<5;i++) {
            final int finalI = i;
            scheduledThreadPool.schedule(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" finalI= "+finalI);
                }
            },3, TimeUnit.SECONDS);
        }
    }
}
