package com.tss.ass10;

public class B implements A {
    @Override
    public void show() {
        System.out.println("B");
        A.super.show();
    }
}
