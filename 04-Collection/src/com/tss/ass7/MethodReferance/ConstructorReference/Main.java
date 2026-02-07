package com.tss.ass7.MethodReferance.ConstructorReference;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        createStudent(101, "Jay", Student::new);
    }

    static void createStudent(int id, String name, BiConsumer<Integer, String> func) {
        func.accept(id,name);
    }

}
