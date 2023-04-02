package com.wang.oop;

public class Computer implements Electronic {

    public static void main(String[] args) {
        Electronic electronic = new Computer();
        electronic.printDescription();
    }

    @Override
    public int getElectricityUse() {
        return 0;
    }
}
