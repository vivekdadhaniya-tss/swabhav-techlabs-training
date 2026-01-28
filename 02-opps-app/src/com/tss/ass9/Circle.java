package com.tss.ass9;

class Circle extends Shape {

    int radius;

    Circle(int radius) {
        this.radius=radius;
    }

    @Override
    void area() {
        System.out.println("Area of Circle: " + (3.14 * radius * radius));
    }
}
