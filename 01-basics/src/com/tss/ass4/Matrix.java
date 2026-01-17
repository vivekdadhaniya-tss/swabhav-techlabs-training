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
            System.out.println("5. Magical Matrix: ");
            System.out.println("6. Prime Matrix: ");
            System.out.println("7. Exit: ");

            int opt = 0;

            while (true) {
                System.out.println("Select option 1-7: ");
                opt = scan.nextInt();

                if (opt >= 0 && opt <= 7)   break;
                System.out.println("Invalid!");
            }

            if (opt == 7) {
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
                case 5:
                    System.out.println((checkMagicaMatrix(m, n, matrix1)) ? "Matrix1 is Magic-Matrix" : "Matrix1 is not Magic-Matrix");
                    System.out.println((checkMagicaMatrix(m, n, matrix2)) ? "Matrix2 is Magic-Matrix" : "Matrix2 is not Magic-Matrix");
                    break;
                case 6:
                    System.out.println((checkPrimeHarmonicMatrix(m, n, matrix1)) ? "Matrix1 is Prime-Harmonic" : "Matrix1 is not Prime-Harmonic");
                    System.out.println((checkPrimeHarmonicMatrix(m, n, matrix2)) ? "Matrix2 is Prime-Harmonic" : "Matrix2 is not Prime-Harmonic");
                    break;

            }

        }

    }

    private static boolean checkMagicaMatrix(int m, int n, int[][] matrix) {
        if(m != n)  return false;

        int magicSum = 0;
        int rowSum = 0;
        int colSum = 0;
        int mainDiagonal = 0;
        int secondaryDiagonal = 0;

        // 1st row as magic sum & diagonal
        for(int i = 0; i < n; i++) {
            magicSum += matrix[0][i];
            mainDiagonal += matrix[i][i];
            secondaryDiagonal += matrix[i][n - i - 1];
        }

        if(mainDiagonal != magicSum || secondaryDiagonal != magicSum)   return false;

        // for row & column
        for (int i = 0; i < n; i++) {
            rowSum = 0;
            colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != magicSum || colSum != magicSum)    return false;
        }

        return true;
    }

    private static boolean checkPrimeHarmonicMatrix(int m, int n, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            int primeCount = 0;
            for (int j = 0; j < n; j++) {
                if(isPrime(matrix[i][j]))   primeCount++;
            }
            if(primeCount != 3) return false;
        }
        return true;
    }

    private static boolean isPrime(int num) {
        if (num <= 1)   return false;
        if (num == 2)   return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= (int) Math.sqrt(num); i+=2) {
            if (num % i == 0)   return false;
        }

        return true;

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
            return;
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                    multiplicationMatrix[i][j] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    multiplicationMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }

    private static void addition(int m, int n, int[][] matrix1, int[][] matrix2, int[][] additionMatrix) {

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                additionMatrix[i][j] = 0;

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
