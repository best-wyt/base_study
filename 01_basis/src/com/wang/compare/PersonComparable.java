package com.wang.compare;

/**
 * @author wyt
 * @date 2023/3/11$
 * @description
 */
public class PersonComparable implements Comparable<PersonComparable>{

    private int id;

    private Integer age;

    private String name;

    public PersonComparable() {
    }

    public PersonComparable(int id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(PersonComparable o) {
        if (this.age.compareTo(o.age) != 0) {
            // 从小到大排序 ，this.age大于返回1 小于返回-1 等于返回0
            return this.age.compareTo(o.age);
        }
        return this.name.compareTo(o.name);
    }
}
