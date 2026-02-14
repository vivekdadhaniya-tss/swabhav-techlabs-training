package com.tss.Structural.Proxy.ProtectionProxy;

public class RealDocument implements Document {

    private String fileName;

    public RealDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void view() {
        System.out.println("Viewing document: " + fileName);
    }

    @Override
    public void delete() {
        System.out.println("Deleting document: " + fileName);
    }
}
