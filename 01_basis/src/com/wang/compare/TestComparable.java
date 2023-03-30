package com.wang.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wyt
 * @date 2023/3/11$
 * @description
 */
public class TestComparable {

    public static void main(String[] args) {
        // 创建对象
        PersonComparable p1 = new PersonComparable(1, 18, "Java");
        PersonComparable p2 = new PersonComparable(2, 22, "MySQL");
        PersonComparable p3 = new PersonComparable(3, 6, "Redis");
        // 添加对象到集合
        List<PersonComparable> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        // 进行排序操作(根据 Person 类中 compareTo 中定义的排序规则)
        Collections.sort(list);
        // 输出集合中的顺序
        list.forEach(p -> System.out.println(p.getName() +
                "：" + p.getAge()));
    }

}
