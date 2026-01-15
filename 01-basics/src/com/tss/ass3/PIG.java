package com.tss.ass3;

import java.util.Random;
import java.util.Scanner;

public class PIG {

    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("==== PIG ====");

        boolean play = true;

        while(play) {
            play = gameStart();
            System.out.println(play ? "\nNext game start..!" : "\nGame end..!");
        }

    }

    private static boolean gameStart() {
        int turn = 1;
        int score = 0;
        while(turn <= 5) {

            System.out.println("--- Turn: " + turn + "---");
            while(score < 20) {
                System.out.print("Roll or hold? (r/h):");
                String rollHold = scan.next();
                int dice = 0;

                if(rollHold.equals("r")) {

                    dice = random.nextInt(1,7);
                    System.out.println("Dice value: " + dice);
                    score +=dice;

                    if (dice == 1) {
                        score = 0;
                        break;
                    }

                } else {
                    break;
                }
            }

            if(score >= 20) {
                System.out.println("You win..! score : " + score);
                break;
            }
            System.out.println("Score: " + score);
            System.out.println();

            turn++;
        }

        if(score < 20) {
            System.out.println("You are lost");
        }

        System.out.println("Do you want to play again ? (true/false):");
        boolean playAgain = scan.nextBoolean();

        return playAgain;
    }
}