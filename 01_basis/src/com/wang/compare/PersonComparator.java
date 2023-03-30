package com.wang.compare;

/**
 * @author wyt
 * @date 2023/3/11$
 * @description
 */
public class PersonComparator{

    private int id;

    private Integer age;

    private String name;

    public PersonComparator() {
    }

    public PersonComparator(int id, Integer age, String name) {
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

}
