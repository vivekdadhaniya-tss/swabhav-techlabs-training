package com.tss.ass2;

import java.util.Random;
import java.util.Scanner;

public class GusserGame {

    public static void main(String[] args) {

//        Random ranNumber = new Random(100);
        Random ranNumber = new Random();
        int randomNumber = ranNumber.nextInt(101);
//        int randomNumber = ranNumber.nextInt(100);

        Scanner scan = new Scanner(System.in);

        boolean check = true;

        while(check) {

            System.out.println("Random number : " + randomNumber);
            boolean res = false;

            for (int i = 0; i < 5; i++) {

                System.out.println("Enter the number(1 to 100):");
                int num = scan.nextInt();

                if(num < 0) {
                    System.out.println("Enter the valid number");
                    i--;
                }

                if (num == randomNumber) {
                    res = true;
                    System.out.println("You won : take " + i + "attempts");
                    break;
                } else if (num < randomNumber) {
                    System.out.println("Sorry, Too low....");
                } else {
                    System.out.println("Sorry,Too high...");
                }
            }

            if (!res) {
                System.out.println("You are lost...");
            }

            System.out.println("Do you want to play again (yes/no): ");
            String ans = scan.next().toLowerCase();

            if(ans.equals("no")) {
                check = false;
            }
        }
    }
}
