package com.wang.socket.juc.demo2;

import cn.hutool.core.lang.Singleton;

//最终优化版
class Singleton2 {
    //懒汉模式, static 创建类时,并没有创建实例!
    //private 保证这里的instance实例只有一份!!!
    //volatile 保证内存可见!!!避免编译器优化!!!
    private static volatile Singleton2 instance = null;

    //私有的构造方法!保证该实例不能再创建
    private Singleton2() {
    }

    //提供一个方法,外界可以获取到该实例!
    public static Singleton2 getInstance() {
        if (instance == null) {//如果未初始化就进行加锁操作!
            synchronized (Singleton.class) { //对读写操作进行加锁!
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        //已经初始化后直接读!!!
        return instance;
    }
}