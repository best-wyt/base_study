package com.wang.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wyt
 * @date 2024/5/18 16:32
 * @description
 */
public class Test1 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }

}
