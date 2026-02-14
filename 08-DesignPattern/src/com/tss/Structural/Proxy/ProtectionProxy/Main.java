package com.tss.Structural.Proxy.ProtectionProxy;

public class Main {
    public static void main(String[] args) {

        Document document1 = new DocumentProxy("salary.pdf", "employee");
        document1.view();
        document1.delete();

        System.out.println();

        Document document2 = new DocumentProxy("salary.pdf", "manager");
        document2.view();
        document2.delete();

    }
}
