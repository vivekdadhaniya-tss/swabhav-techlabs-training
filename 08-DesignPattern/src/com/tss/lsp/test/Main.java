package com.tss.lsp.test;

import com.tss.lsp.model.Human;
import com.tss.lsp.model.Robot;

public class Main {
    public static void main(String[] args) {
        // Human
        Human human = new Human();
        human.eat();
        human.rest();
        human.doWork();

        System.out.println();

        // Robot
        Robot robot = new Robot();
        robot.charge();
        robot.doWork();
    }
}
