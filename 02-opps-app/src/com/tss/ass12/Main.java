package com.tss.ass12;

public class Main {
    public static void main(String[] args) {

        Voter voter1 = null;
        try {
            voter1 = new Voter(1, "Vivek", 16);
            System.out.println("Voter created successfully");
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(voter1);
    }
}
