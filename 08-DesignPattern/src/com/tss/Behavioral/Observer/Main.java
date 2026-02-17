package com.tss.Behavioral.Observer;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account account = new Account(1L, "10100115", "Vivek", 1000);

        int choice;

        do {
            System.out.println("\n==== Select Notifier to Add ====");
            System.out.println("1. Email Notifier");
            System.out.println("2. SMS Notifier");
            System.out.println("3. Done");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    account.addNotifier(new EmailNotifier(email));
                    System.out.println("Email Notifier Added!");
                    break;

                case 2:
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();
                    account.addNotifier(new SMSNotifier(phone));
                    System.out.println("SMS Notifier Added!");
                    break;

                case 3:
                    System.out.println("Notifier selection completed.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        int operation;

        do {
            System.out.println("\n==== Account Menu ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            operation = sc.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (operation != 3);

        sc.close();
    }
}