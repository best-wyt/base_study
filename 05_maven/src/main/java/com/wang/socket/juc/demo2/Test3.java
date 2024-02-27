package com.wang.socket.juc.demo2;

import java.util.Random;

//测试代码
public class Test3 {
    public static void main(String[] args) {
        MyblockingQueue queue = new MyblockingQueue();
        Thread customer = new Thread(() -> {
            while (true) {
                System.out.println("消费了" + queue.take());
            }
        });
        Thread producer = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int x = random.nextInt(100);
                System.out.println("生产了" + x);
                queue.put(x);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();
        producer.start();
    }
}