package com.xufx.ThreadPool.FixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for(int i=0;i<10;i++){
            final int finalI = i;
            fixedThreadPool.execute(new Runnable() {
                        public void run() {
                            System.out.println(Thread.currentThread().getName()+ "  finalI ="+finalI);
                        }
                    });
        }

    }
}
