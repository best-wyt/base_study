package com.wang.socket.juc.demo2;

//阻塞队列
class MyblockingQueue {
    //阻塞队列
    private int[] data = new int[100];
    //队头
    private int start = 0;
    //队尾
    private int tail = 0;
    //元素个数, 用于判断队列满
    private int size = 0;
    //锁对象
    Object locker = new Object();

    public void put(int x) {
        synchronized (locker) {//对该操作加锁
            //入队操作
            if (size == data.length) {
                //队列满 阻塞等待!!!直到put操作后notify才会继续执行
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data[tail] = x;
            tail++;//入队
            if (tail == data.length) {
                //判断是否需要循环回
                tail = 0;
            }
            size++; //入队成功加1
            //入队成功后通知take 如果take阻塞
            locker.notify();//这个操作线程阻塞并没有副作用!
        }
    }

    public Integer take() {
        //出队并且获取队头元素
        synchronized (locker) {
            if (size == 0) {
                //队列为空!阻塞等待 知道队列有元素put就会继续执行该线程
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int ret = data[start]; //获取队头元素
            start++; //出队
            if (start == data.length) {
                //判断是否要循环回来
                start = 0;
            }
            // start = start % data.length;//不建议可读性不搞,效率也低
            size--;//元素个数减一
            locker.notify();//通知 put 如果put阻塞!
            return ret;
        }
    }
}