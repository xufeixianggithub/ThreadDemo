package com.xufx.ThreadPool.StopThread;

public class StopThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        StopThread stopThread1 = new StopThread();
        Thread thread1 = new Thread(stopThread1);
        Thread thread2 = new Thread(stopThread1);
        thread1.start();
        thread2.start();
        int i = 0;
        while (true) {
            //System.out.println("thread main..");
            if (i == 300) {
                //stopThread1.notify();

                Thread.sleep(3000);

                // stopThread1.stopThread();
                thread1.interrupt();
                thread2.interrupt();
                break;
            }
            i++;
        }

    }

}