package com.wang.test;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author wyt
 * @date 2024/3/26 21:46
 * @description
 */
public class Test1 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();

        // 定义一个注册器，用来注册和管理BeanDefinition
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

        // 通过xml文件加载
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(registry);
        xmlReader.loadBeanDefinitions("classpath:spring.xml");
    }


    public void test1() {
        ThreadLocal<Map<String , Object>> threadLocal = new ThreadLocal<>();
    }


}
