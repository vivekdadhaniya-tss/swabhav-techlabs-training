package com.tss.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameValidatorTest {

    GameValidator gameValidator;

    @BeforeEach
    void setup() {
        gameValidator = new GameValidator();
    }

    @Test
    void rowWinTest() {
        char[][] grid = {
                {'X', 'X', 'X'},
                {'-', 'O', '-'},
                {'O', '-', '-'}
        };

        assertTrue(gameValidator.checkWin(grid, 'X'));
    }

    @Test
    void colWinTest() {
        char[][] grid = {
                {'O', 'X', '-'},
                {'O', 'X', '-'},
                {'O', '-', '-'}
        };
        assertTrue(gameValidator.checkWin(grid, 'O'));
    }

    @Test
    void diagonalWinTest() {
        char[][] grid = {
                {'-', 'O', 'X'},
                {'-', 'X', 'O'},
                {'X', '-', 'O'}
        };
        assertTrue(gameValidator.checkWin(grid, 'X'));
    }

    @Test
    void drawTest() {
        char[][] grid = {
                {'X','O','X'},
                {'O','X','O'},
                {'O','X','O'}
        };
        assertFalse(gameValidator.checkWin(grid, 'X'));
    }
}