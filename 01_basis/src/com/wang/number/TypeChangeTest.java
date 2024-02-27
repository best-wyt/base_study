package com.wang.number;

import org.junit.Test;

/**
 * @author wyt
 * @date 2023/4/5 12:27
 * @description
 */
public class TypeChangeTest {

    @Test
    public void test1() {
        // 不正确。3.4 是双精度数，将双精度型（double）赋值给浮点型（float）属于下转型（down-casting，也称为窄化）会造成精度损失，
        // 因此需要强制类型转换float f =(float)3.4;或者写成float f =3.4F
//        float f=3.4;
        // 正确。float自动向上转型
        double d = 3.4f;

        short s1 = 1;
        //s1 = s1 + 1;编译出错，由于 1 是 int 类型，因此 s1+1 运算结果也是 int 型，需要强制转换类型才能赋值给 short 型。
//        s1 = s1 + 1;

        // s1 += 1;可以正确编译，因为 s1+= 1;相当于 s1 = (short(s1 + 1);其中有隐含的强制类型转换。
        s1 += 1;

    }

    @Test
    public void test2() {
        char a = 'a';
        int aa = a;
        System.out.println(aa);
        int b = '1';
        System.out.println(b);
        int c = Character.getNumericValue('1');
        System.out.println(c);
        int d = Character.getNumericValue('b');
        System.out.println(d);
    }

}
