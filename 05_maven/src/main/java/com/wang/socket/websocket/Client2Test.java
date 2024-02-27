package com.wang.socket.websocket;

import java.net.URI;
import java.net.URISyntaxException;

public class Client2Test {


    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        sendMessage();
    }

    static void sendMessage() throws InterruptedException, URISyntaxException {
        Client2 client2 = new Client2(new URI("ws://58.247.254.10:58080/webSocket?token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2tlbiIsInVzZXIiOiJ7XCJpZENhcmROb1wiOlwiMDAwMDAwMDAwMDAwMDAwMDAwXCIsXCJvcmdOb1wiOlwiMVwiLFwidXNlcklkXCI6XCIxXCIsXCJ1c2VyTmFtZVwiOlwi5byg5LiJXCJ9IiwiaWF0IjoxNjkxMzg3ODAxLCJleHAiOjEwMzMxMzAxNDAxfQ.yByjPERGUCXjCA_K8Y_1iw3B768R-rh4vywwvVb7s7E"));
        client2.connect();
        Client2 client3 = new Client2(new URI("ws://58.247.254.10:58080/webSocket?token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2tlbiIsInVzZXIiOiJ7XCJpZENhcmROb1wiOlwiMDAwMDAwMDAwMDAwMDAwMDAxXCIsXCJvcmdOb1wiOlwiMVwiLFwidXNlcklkXCI6XCIxXCIsXCJ1c2VyTmFtZVwiOlwi5byg5LiJXCJ9IiwiaWF0IjoxNjkxMzkxMjk1LCJleHAiOjEwMzMxMzA0ODk1fQ.WWCL9rrKkZfgVKAPzDDSLlx_7vvFooLUrtd9tYYgSCk"));
        client3.connect();


//        while (true) {
//            if (client2.isOpen()) {
//                client2.send("Hello");
//            }
//            Thread.sleep(1000);
//        }
    }
}