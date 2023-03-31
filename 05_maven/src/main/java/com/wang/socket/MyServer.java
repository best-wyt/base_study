package com.wang.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {
    //<= 65535
    private static final int PORT = 65535;

    public static void main(String[] args) throws Exception {

        try (ServerSocket listener = new ServerSocket(PORT)) {
            System.out.println("Server Started");
            //线程池大小，它根据客户端数来决定，当大于10时，则之前的10个线程仍然可以工作，
            // 而超过的线程则进入队列中，等待。
            //当之前的客户端释放量后，则在队列中的线程仍然可以工作。
            ExecutorService pool = Executors.newFixedThreadPool(10);
            while (true) {
                //多线程
                pool.execute(new MyServerDemo01(listener.accept()));
                System.out.println(pool);
            }
        }
    }
    //Runnable接口的实现对象可以被线程Thread调用
    private static class MyServerDemo01 implements Runnable {

        private Socket socket;

        MyServerDemo01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Client [" + socket.getRemoteSocketAddress().toString()+" ] Connected");
            try {
                //输入
                Scanner in = new Scanner(socket.getInputStream());
                //输出
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                while (in.hasNextLine()) {
                    String msg = in.nextLine();
                    System.out.println("Client [" + socket.getRemoteSocketAddress().toString()+" ] : " + msg);
                    out.println(msg.toUpperCase());
                }
            } catch (Exception e) {
                System.out.println("Error:" + socket+ e.getMessage());
            } finally {
                try {
                    //关闭socket
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Closed: " + socket);
            }
        }
    }
}