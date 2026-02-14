package com.tss.tictactoe;

public class GameValidator {

    public boolean checkWin(char[][] grid, char symbol) {

        for(int i=0; i<grid.length; i++) {
            if(grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol ||
                    grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) {
                return true;
            }
        }

        if(grid[0][0] == symbol && grid[1][1] == symbol && grid[0][2] == symbol ||
            grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            return true;
        }

        return false;
    }
}
