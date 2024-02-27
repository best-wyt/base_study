package com.wang.test;

import com.wang.TestBootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wyt
 * @date 2023/9/2 18:26
 * @description
 */

@SpringBootTest(classes = TestBootApplication.class) // 可以使用spring的功能
public class Test2 {


    @Test
    public void test1() {
        System.out.println("1");
    }


}
