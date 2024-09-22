package com.wang.mytest;

/**
 * @author wyt
 * @date 2024/8/12 16:37
 * @description
 */
public class StrTest {

    public static void main(String[] args) {
//        int a = 'a';
//        int z = 'z';
//        int A = 'A';
//        int Z = 'Z';
//        System.out.println("a=" + a + ",z=" + z + ",A=" + A + ",Z=" + Z);

        String str = "qwe123";
        System.out.println(getStr(str));

    }


    public static String getStr(String str) {
        char[] chars = new char[str.length()];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            int x = str.charAt(i);
            if ((65 <= x && x<= 90) || (97<= x && x<=122)) {
                chars[index++] = str.charAt(i);
            }
        }
        return new String(chars);
    }

}
