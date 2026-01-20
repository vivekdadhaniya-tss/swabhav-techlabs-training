package com.tss.ass1.test;

import com.tss.ass1.model.Box;
import java.util.Scanner;

public class BoxTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box[] boxes = new Box[3];

        for (int i = 0; i < boxes.length; i++) {
            System.out.println("Box " + (i + 1) + ":");

            System.out.print("Enter width: ");
            double width = scan.nextDouble();

            System.out.print("Enter height: ");
            double height = scan.nextDouble();

            System.out.print("Enter depth: ");
            double depth = scan.nextDouble();

            boxes[i] = new Box(width, height, depth);

            System.out.println("\n=== Box " + (i + 1) + " details ===");
            boxes[i].display();
            System.out.println("Volume: " + boxes[i].volume());
            System.out.println("\n");
        }

        scan.close();
    }
}
