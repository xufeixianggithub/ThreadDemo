package com.xufx.ThreadPool.Condition;

import java.util.concurrent.locks.Condition;

class InputThread extends Thread {
    private Res res;
    Condition newCondition;
    public InputThread(Res res, Condition newCondition) {
        this.res = res;
        this.newCondition=newCondition;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            // synchronized (res) {

            try {
                res.lock.lock();
                if (res.flag) {
                    try {
//                      res.wait();
                        newCondition.await();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                if (count == 0) {
                    res.userName = "余胜军";
                    res.sex = "男";
                } else {
                    res.userName = "小红";
                    res.sex = "女";
                }
                count = (count + 1) % 2;
                res.flag = true;
//              res.notify();
                newCondition.signal();
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                res.lock.unlock();
            }
        }

        // }
    }
}