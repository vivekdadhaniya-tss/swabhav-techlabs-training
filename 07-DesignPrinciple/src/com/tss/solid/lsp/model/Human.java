package com.tss.solid.lsp.model;

public class Human implements IHuman {

    @Override
    public void eat() {
        System.out.println("Human is eating.");
    }

    @Override
    public void rest() {
        System.out.println("Human is resting.");
    }

    @Override
    public void doWork() {
        System.out.println("Human is working.");
    }
}
