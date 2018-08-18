package com.xufx.ThreadPool.StopThread;

class StopThread implements Runnable {
    private boolean flag = true;

    public synchronized void run() {
        while (flag) {
            try {
                wait();
            } catch (Exception e) {
                //e.printStackTrace();
                stopThread();
            }
            System.out.println("thread run..");
        }
    }
    public void stopThread() {
        flag = false;
    }
}