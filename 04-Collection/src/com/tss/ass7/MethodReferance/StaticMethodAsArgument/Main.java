package com.tss.ass7.MethodReferance.StaticMethodAsArgument;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        processNumber(5, MathUtil::square);
    }

    static void processNumber(int n, Function<Integer, Integer> func) {
        System.out.println(func.apply(n));
    }

}
