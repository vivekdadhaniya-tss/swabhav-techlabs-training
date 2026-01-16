package com.tss.ass4;

import java.util.Scanner;

public class Matrix {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter value of m: ");
        int m = scan.nextInt();
        System.out.println("Enter value of n: ");
        int n = scan.nextInt();

        int[][] matrix1 = new int[m][n];
        int[][] matrix2 = new int[m][n];
        int[][] additionMatrix = new int[m][n];
        int[][] multiplicationMatrix = new int[m][n];

        while (true) {
            System.out.println("1. Create Matrix: ");
            System.out.println("2. Display Matrix: ");
            System.out.println("3. Addition Matrix: ");
            System.out.println("4. Multiplication Matrix: ");
            System.out.println("5. Exit: ");

            int opt = 0;

            while (true) {
                System.out.println("Select option 1-5: ");
                opt = scan.nextInt();

                if (opt < 0 || opt > 5) {
                    System.out.println("Invalid!");
                }
                break;
            }

            if(opt == 5) {
                return;
            }

            switch (opt) {
                case 1:
                    System.out.println("Enter elements of matrix1:");
                    createMatrix(m, n, matrix1);
                    System.out.println("Enter elements of matrix2:");
                    createMatrix(m, n, matrix2);
                    break;
                case 2:
                    System.out.println("Display Matrix1 :");
                    display(matrix1);
                    System.out.println("Display Matrix2 :");
                    display(matrix2);
                    System.out.println("Display Addition Matrix :");
                    display(additionMatrix);
                    System.out.println("Display Multiplication Matrix :");
                    display(multiplicationMatrix);
                    break;
                case 3:
                    addition(m, n, matrix1, matrix2, additionMatrix);
                    break;
                case 4:
                    multiplication(m, n, matrix1, matrix2, multiplicationMatrix);
                    break;
            }

        }

    }

    private static void createMatrix(int m, int n, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
    }

    private static void multiplication(int m, int n, int[][] matrix1, int[][] matrix2, int[][] multiplicationMatrix) {
        if (m != n) {
            System.out.println("You can not multiply...!");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    multiplicationMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }

    private static void addition(int m, int n, int[][] matrix1, int[][] matrix2, int[][] additionMatrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                additionMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }

    private static void display(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
