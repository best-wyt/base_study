package com.wang.oop;

/**
 * @author wyt
 * @date 2023/3/25 18:38
 * @description 孩子A
 */
public class AChildClass extends FatherClass{

    public String a = "a";
    protected String b = "b";
    String c = "c";
    private String d = "d";


    @Override
    void method22() {
        System.out.println("method22");
    }

    @Override
    protected void method33() {
        System.out.println("method33");
    }

    @Override
    public void method44() {
        System.out.println("method44");
    }
}
