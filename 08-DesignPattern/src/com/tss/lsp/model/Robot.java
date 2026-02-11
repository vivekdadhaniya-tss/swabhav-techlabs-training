package com.tss.lsp.model;

public class Robot implements IRobot {
    @Override
    public void charge() {
        System.out.println("Robot is charging.");
    }

    @Override
    public void doWork() {
        System.out.println("Robot is working.");
    }
}
