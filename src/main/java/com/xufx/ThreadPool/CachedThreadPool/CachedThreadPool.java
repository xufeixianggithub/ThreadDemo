package com.xufx.ThreadPool.CachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//总结: 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
public class CachedThreadPool {
    public static void main(String[] args) {
        // 无限大小线程池 jvm自动回收
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newCachedThreadPool.execute(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);

                }
            });
        }
    }

}
