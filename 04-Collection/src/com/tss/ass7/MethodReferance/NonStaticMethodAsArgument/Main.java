package com.tss.ass7.MethodReferance.NonStaticMethodAsArgument;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();
        processMessage("Hello Java", printer::print);
    }

    static void processMessage(String msg, Consumer<String> consumer) {
        consumer.accept(msg);
    }

}
