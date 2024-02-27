package com.wang.socket.juc.demo1;

import lombok.Data;

@Data
public class Cat {
    private String catName;
    public Cat setCatName(String name) {
        this.catName = name;
        return this;
    }
}