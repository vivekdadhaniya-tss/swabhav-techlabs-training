package com.tss.ass10;

public interface A {

    default void show() {
        print();
    }

    private void print() {
        System.out.println("Private of A");
    }
}
