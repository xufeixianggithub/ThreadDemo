package com.xufx.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Test001 {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            Writer writer = new Writer(cyclicBarrier);
            writer.start();
        }
    }

}