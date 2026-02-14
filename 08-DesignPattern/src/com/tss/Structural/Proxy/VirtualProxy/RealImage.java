package com.tss.Structural.Proxy.VirtualProxy;

public class RealImage implements Image {

    private String filePath;

    public RealImage(String filePath) {
        this.filePath = filePath;
        loadFromDisk(); // heavy operation
    }

    public void loadFromDisk() {
        System.out.println("Loading image from disk: " + filePath);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filePath);
    }
}
