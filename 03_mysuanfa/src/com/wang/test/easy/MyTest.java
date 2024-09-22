package com.wang.test.easy;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTest {
    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1 , 2 , 1 , TimeUnit.SECONDS , new LinkedBlockingQueue<>());

        threadPoolExecutor.execute(() ->{});

        System.out.println(fibonacci(10));

    }
 
    public static long fibonacci(long fn) {
        if ((fn == 0) || (fn == 1)) {
            return fn;
		}
		
        return fibonacci(fn - 1) + fibonacci(fn - 2);
    }
}