package com.xufx.ThreadPool.Condition;

import java.util.concurrent.locks.Condition;

public class ThreadDemo01 {

    public static void main(String[] args) {
        Res res = new Res();
        Condition newCondition = res.lock.newCondition();
        InputThread inputThread = new InputThread(res,newCondition);
        OutThrad outThrad = new OutThrad(res,newCondition);
        inputThread.start();
        outThrad.start();
    }

}