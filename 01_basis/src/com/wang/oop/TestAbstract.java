package com.wang.oop;

/**
 * @author wyt
 * @date 2023/3/25 18:43
 * @description
 */
public class TestAbstract {


    public static void main(String[] args) {
        AChildClass A = new AChildClass();
        System.out.println(A.a);
        System.out.println(A.b);
        System.out.println(A.c);
        System.out.println(AChildClass.variable1);
        System.out.println(AChildClass.variable2);
        System.out.println(AChildClass.variable3);
//        System.out.println(AChildClass.variable4);
        A.method22();
        A.method2();
    }

}
