package com.wang.compare;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyt
 * @date 2023/3/11$
 * @description
 */
public class TestComparator {
    public static void main(String[] args) {
        // 构建并添加数据
        List<PersonComparator> list = new ArrayList<>();
        list.add(new PersonComparator(1, 18, "Java"));
        list.add(new PersonComparator(2, 20, "MySQL"));
        list.add(new PersonComparator(3, 6, "Redis"));
        // 使用 Comparator 匿名类的方式进行排序,从大到小排序  p1.age大于返回正数 小于返回负数 等于返回0； 取反就改变排序顺序
        list.sort((p1, p2) -> p2.getAge() - p1.getAge());
        // 打印集合数据
        list.forEach(p -> System.out.println(p.getName() +
                "：" + p.getAge()));
    }

}
