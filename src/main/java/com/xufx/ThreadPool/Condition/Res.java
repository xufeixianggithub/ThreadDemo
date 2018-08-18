package com.xufx.ThreadPool.Condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res {
    public String userName;
    public String sex;
    public boolean flag = false;
    Lock lock = new ReentrantLock();
}