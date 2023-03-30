package com.wang.test.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wyt
 * @date 2023/3/15 20:41
 * @description 无重复字符的最长子串
 */
public class LongestSonStr {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(getLongest2(str));
    }


    /**
     * @Author: wyt
     * @Description: 滑动窗口解法
     * @DateTime: 2023/3/15 20:42
     */
    public static int getLongest1(String str) {

        int max = 0;
        int length = str.length();
        int right = 0;
        Set<Character> chars = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                chars.remove(str.charAt(i - 1));
            }
            while (right < length && !chars.contains(str.charAt(right))) {
                chars.add(str.charAt(right++));
            }
            max = Math.max(max, right - i);

        }
        return max;

    }

    public static int getLongest2(String s) {

        int m = s.length();
        int num = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            // i-num 不重复子串的起始位置
            // 获取离当前字符最近的相同字符的坐标
            int index = s.indexOf(s.charAt(i), i - num);
            // 如果index == i 表明之前未出现过该字符 所以num + 1，否则已出现该字符，那么这两个相同字符之间的距离就是不重复子串长度
            if (index == i) {
                num = num + 1;
            } else {
                num = i - index;
            }
            max = Math.max(max, num);
        }
        return max;

    }

}
