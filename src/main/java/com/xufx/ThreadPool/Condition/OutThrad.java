package com.xufx.ThreadPool.Condition;

import java.util.concurrent.locks.Condition;

class OutThrad extends Thread {
    private Res res;
    private Condition newCondition;
    public OutThrad(Res res,Condition newCondition) {
        this.res = res;
        this.newCondition=newCondition;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//          synchronized (res) {
            try {
                res.lock.lock();
                if (!res.flag) {
                    try {
//                      res.wait();
                        newCondition.await();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                System.out.println(res.userName + "," + res.sex);
                res.flag = false;
//              res.notify();
                newCondition.signal();
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                res.lock.unlock();
            }
//          }
        }

    }
}