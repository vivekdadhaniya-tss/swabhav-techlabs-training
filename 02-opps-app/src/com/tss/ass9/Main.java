package com.tss.ass9;

public class Main {
    public static void main(String[] args) {

        Shape s1 = new Circle(10);
        Shape s2 = new Square(10);
        Shape s3 = new Triangle(10,10);

        s1.display();
        s1.area();

        s2.display();
        s2.area();

        s3.display();
        s3.area();
    }
}
