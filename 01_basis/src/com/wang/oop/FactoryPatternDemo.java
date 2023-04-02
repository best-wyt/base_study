package com.wang.oop;

// 教练
interface Coach2 {
    void command();
}

// 教练学院
interface CoachFactory {
    Coach2 createCoach();
}

// A级教练
class ACoach implements Coach2 {

    @Override
    public void command() {
        System.out.println("我是A级证书教练");
    }
    
}

// A级教练学院
class ACoachFactory implements CoachFactory {

    @Override
    public Coach2 createCoach() {
        return new ACoach();
    }
    
}

// C级教练
class CCoach implements Coach2 {

    @Override
    public void command() {
        System.out.println("我是C级证书教练");
    }
    
}

// C级教练学院
class CCoachFactory implements CoachFactory {

    @Override
    public Coach2 createCoach() {
        return new CCoach();
    }
    
}

/**
* @Author: wyt
* @Description: 工厂模式
 * 有两个接口，一个是 Coach（教练），可以 command()（指挥球队）；
 * 另外一个是 CoachFactory（教练学院），能 createCoach()（教出一名优秀的教练）。
 * 然后 ACoach 类实现 Coach 接口，ACoachFactory 类实现 CoachFactory 接口；
 * CCoach 类实现 Coach 接口，CCoachFactory 类实现 CoachFactory 接口。
 * 当需要 A 级教练时，就去找 A 级教练学院；当需要 C 级教练时，就去找 C 级教练学院。
* @DateTime: 2023/4/2 22:05
*/
public class FactoryPatternDemo {
    public static void create(CoachFactory factory) {
        factory.createCoach().command();
    }
    
    public static void main(String[] args) {
        // 对于一支球队来说，需要什么样的教练就去找什么样的学院
        // 学院会介绍球队对应水平的教练。
        create(new ACoachFactory());
        create(new CCoachFactory());
    }
}