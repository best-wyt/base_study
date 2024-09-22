package com.wang.test;

import java.util.Stack;

/**
 * @author wyt
 * @date 2023/3/14 12:28
 * @description 字符串变形 BM83
 */
public class StringChange {

    public static void main(String[] args) {

        StringBuilder s = new StringBuilder("" + 1);
        int y = Integer.parseInt(s.reverse().toString());
        System.out.println(trans("This is a sample", 16));

    }

    public static String trans(String s, int n) {
        // write code here
        StringBuilder build = new StringBuilder(n);
        // 将整个字符串大小写转变
        for (int i = 0; i < n; i++) {
            // 大写
            if (64 <= s.charAt(i) && s.charAt(i) <= 90) {
                build.append((char) (s.charAt(i) + 32));
            } else if (97 <= s.charAt(i) && s.charAt(i) <= 122) {
                build.append((char) (s.charAt(i) - 32));
            } else {
                build.append(s.charAt(i));
            }
        }
        // 旋转字符串
        build.reverse();
        String newStr = build.toString();
        String[] split = newStr.split(" ");
        if (split.length==0){
            return s;
        }
        Stack<String> stack = new Stack<>();
        for (String s1 : split) {
            stack.push(s1);
        }
        build.delete(0, n);
        while (true) {
            build.append(stack.pop());
            if (stack.empty()) {
                break;
            }
            build.append(" ");
        }
        return build.toString();
    }

}

