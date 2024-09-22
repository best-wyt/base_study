package com.wang.test.str;

import java.util.*;

/**
 * @author wyt
 * @date 2024/5/13 20:59
 * @description
 */
public class StrReverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String inPutStr = in.next();
            Deque<Character> deque = new ArrayDeque<>();
            char[] chars = inPutStr.toCharArray();
            for (int i = 0; i < inPutStr.length(); i++) {
                deque.push(chars[i]);
            }
            String resultStr = "";
            Iterator<Character> iterrator = deque.iterator();
            while (iterrator.hasNext()) {
                resultStr += iterrator.next();
            }
            System.out.print(resultStr);
        }
    }



    public void test() {
        Stack<Character> stack = new Stack<>();
    }


}
