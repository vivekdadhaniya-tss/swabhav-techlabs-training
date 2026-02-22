package com.tss.tictactoe;

public class Board {

    private char[][] grid = new char[3][3];

    public Board() {
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public boolean placeMove(int row, int col, char symbol) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return false;
        }

        if(grid[row][col] == '-') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void printBoard() {
        for(char[] row : grid) {
            for(char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
