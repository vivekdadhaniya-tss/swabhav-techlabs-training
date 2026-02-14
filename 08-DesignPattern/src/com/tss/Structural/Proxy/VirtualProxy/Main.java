package com.tss.Structural.Proxy.VirtualProxy;

public class Main {
    public static void main(String[] args) {

        Image image = new ProxyImage("C:/images/photo.jpg");

        System.out.println("Proxy object created....");
        System.out.println("Real image is not loaded yet.\n");

        // first call so load image
        image.display();

        System.out.println();

        // second call not load image
        image.display();
    }
}
