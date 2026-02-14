package com.tss.Structural.Proxy.VirtualProxy;

public class ProxyImage implements Image {

    private RealImage realImage;
    private String filePath;

    public ProxyImage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void display() {

        // lazy initialization
        if(realImage == null) {
            realImage = new RealImage(filePath);
        }

        realImage.display();
    }
}
