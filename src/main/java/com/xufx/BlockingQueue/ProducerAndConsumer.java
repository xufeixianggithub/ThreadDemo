package com.xufx.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
        ProducerThread producerThread1 = new ProducerThread(queue);
        ProducerThread producerThread2 = new ProducerThread(queue);
        ConsumerThread consumerThread1 = new ConsumerThread(queue);
        Thread t1 = new Thread(producerThread1);
        Thread t2 = new Thread(producerThread2);
        Thread c1 = new Thread(consumerThread1);
        t1.start();
        t2.start();
        c1.start();

        // 执行10s
        Thread.sleep(10 * 1000);
        producerThread1.stop();
        producerThread2.stop();

    }
}