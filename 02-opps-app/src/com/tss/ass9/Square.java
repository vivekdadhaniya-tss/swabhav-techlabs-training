package com.tss.ass9;

class Square extends Shape {

    int length;

    Square(int radius) {
        this.length =radius;
    }

    @Override
    void area() {
        System.out.println("Area of Square: " + (length * length));
    }
}
