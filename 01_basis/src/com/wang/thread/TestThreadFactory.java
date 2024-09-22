package com.wang.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wyt
 * @date 2024/6/25 21:24
 * @description
 */
public class TestThreadFactory {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(1 , 1 , 1 , TimeUnit.SECONDS , new LinkedBlockingQueue<>());
        executorService.execute(() -> System.out.println("111"));

    }

}
