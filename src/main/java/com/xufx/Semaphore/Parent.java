package com.xufx.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Parent implements Runnable {
    private String name;
    private Semaphore wc;
    public Parent(String name,Semaphore wc){
        this.name=name;
        this.wc=wc;
    }
    public void run() {
        try {
            // 剩下的资源(剩下的茅坑 获取后减一)
            int availablePermits = wc.availablePermits();
            if (availablePermits > 0) {
                System.out.println(name+"天助我也,终于有茅坑了...");
            } else {
                System.out.println(name+"怎么没有茅坑了...");
            }
            //申请茅坑 如果资源达到3次，就等待
            wc.acquire();
            System.out.println(name+"终于轮我上厕所了..爽啊");
               Thread.sleep(new Random().nextInt(1000)); // 模拟上厕所时间。
            System.out.println(name+"厕所上完了...");
            wc.release();

        } catch (Exception e) {

        }
    }
}