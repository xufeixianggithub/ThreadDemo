package com.xufx.ThreadPool.SingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            final int finalI = i;
            singleThreadExecutor.execute(new Runnable() {

                public void run() {
                    System.out.println(" finalI= "+ finalI);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
