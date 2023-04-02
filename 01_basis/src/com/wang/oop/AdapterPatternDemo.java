package com.wang.oop;

interface Coach1 {
    void defend();

    void attack();
}

// 抽象类实现接口，并置空方法
abstract class AdapterCoach1 implements Coach1 {
    @Override
    public void defend() {
    }

    ;

    @Override
    public void attack() {
    }

    ;
}

// 新类继承适配器
class Hesai1 extends AdapterCoach1 {
    @Override
    public void defend() {
        System.out.println("防守赢得冠军");
    }
}

/**
 * @Author: wyt
 * @Description: 适配器模式
 * 如果我们只需要对其中一个方法进行实现的话，就可以使用一个抽象类作为中间件，即适配器（AdapterCoach），
 * 用这个抽象类实现接口，并对抽象类中的方法置空（方法体只有一对花括号），
 * 这时候，新类就可以绕过接口，继承抽象类，我们就可以只对需要的方法进行覆盖，而不是接口中的所有方法。
 * @DateTime: 2023/4/2 22:02
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Coach1 coach = new Hesai1();
        coach.defend();
    }
}