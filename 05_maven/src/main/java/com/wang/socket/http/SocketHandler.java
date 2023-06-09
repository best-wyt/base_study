package com.wang.socket.http;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

class SocketHandler implements Runnable {

    final static String CRLF = "\r\n";

    private Socket clientSocket;

    public SocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void handleSocket(Socket clientSocket) throws IOException {

        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),
                true
        );


        StringBuilder requestHeader = new StringBuilder();
        String s;
        while ((s = in.readLine()) != null) {
            // 2 很重要，默认情况下in.readLine的结果中`\r\n`被去掉了
            s += CRLF;
            requestHeader.append(s);
            // 3 此处HTTP请求头我们都得到了；如果从请求头中判断有请求正文，则还需要继续获取数据
            if (s.equals(CRLF)) {
                break;
            }
        }
        System.out.println("客户端请求头：");
        System.out.println(requestHeader);

        String responseBody = "客户端的请求头是：\n" + requestHeader;
        // 4 问题来了：1、浏览器如何探测编码 2、浏览器受到content-length后会按照什么方式判断？汉字的个数？字节数？
        String responseHeader = "HTTP/1.0 200 OK\r\n" +
                "Content-Type: text/plain; charset=UTF-8\r\n" +
                "Content-Length: " + responseBody.getBytes().length + "\r\n" +
                "\r\n";

        out.write(responseHeader);
        out.write(responseBody);
        out.flush();

        out.close();
        in.close();
        clientSocket.close();

    }

    @Override
    public void run() {
        try {
            handleSocket(clientSocket);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}