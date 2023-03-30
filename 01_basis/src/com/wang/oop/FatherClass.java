package com.wang.oop;

/**
 * @author wyt
 * @date 2023/3/25 18:27
 * @description
 */
abstract class FatherClass {

    public static final String variable1 = "抽象类的public静态参数。";

    static final String variable2 = "抽象类的default静态参数。";

    protected static final String variable3 = "抽象类的protected静态参数。";

    private static final String variable4 = "抽象类的protected静态参数。";


    private void method1() {
        System.out.println("抽象类的private方法！");
    }

    // 抽象方法不可以是 private 的
//    private abstract void method11();

    final void method2() {
        System.out.println("抽象类的default方法！");
    }

    abstract void method22();

    protected void method3 () {
        System.out.println("抽象类的protected方法！");
    }

    protected abstract void method33 ();

    public void method4 () {
        System.out.println("抽象类的public方法！");
    }

    public abstract void method44 ();


}
