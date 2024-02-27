package com.wang.juc.test1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wyt
 * @date 2023/9/21 21:53
 * @description
 */
public class TestSellTicket {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SellTicket sellTicket = new SellTicket();
        Thread thread1 = new Thread(() -> {
            while (sellTicket.getTickets() > 0) {
                try {
                    lock.lock();
                    Thread.sleep(100);
                    sellTicket.sell();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread1.setName("线程1");

        Thread thread2 = new Thread(() -> {
            while (sellTicket.getTickets() > 0) {
                try {
                    lock.lock();
                    Thread.sleep(100);
                    sellTicket.sell();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }

}
