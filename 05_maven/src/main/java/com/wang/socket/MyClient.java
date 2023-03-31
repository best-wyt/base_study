package com.wang.socket;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    //<= 65535
    private static final int PORT = 65535;
    //服务器地址
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) throws Exception {

        try (Socket socket = new Socket(IP, PORT)) {
            System.out.println("Client ["+socket.getRemoteSocketAddress().toString()+" ] Started");
            Scanner scanner = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println("Server Response:"+ in.nextLine());
            }
        }catch (Exception ex){
            System.out.println("Error : "+ ex.getMessage());
        }
    }
}