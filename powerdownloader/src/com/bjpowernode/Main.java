package com.bjpowernode;

import java.util.Scanner;

/**
 * @author wyt
 * @date 2024/2/27 21:17
 * @description
 */
public class Main {
    public static void main(String[] args) {
        String url = null;
        if (args == null || args.length == 0) {
            for(;;) {
                System.out.println("请输入下载链接");
                Scanner scanner = new Scanner(System.in);
                url = scanner.next();
                if (url != null) {
                    break;
                }
            }
        } else {
            url = args[0];
        }
    }
}
