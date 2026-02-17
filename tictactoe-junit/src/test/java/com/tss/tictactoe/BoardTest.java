package com.tss.tictactoe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeAll
    static void setupOnce() {
        System.out.println("Starting Board Tests...");
    }

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Board should initialize all cells with '-'")
    void initializeBoard_ShouldFillWithDash() {

        char[][] grid = board.getGrid();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                assertEquals('-', grid[i][j]);
            }
        }
    }

    @Test
    @DisplayName("placeMove should return true when cell is empty")
    void placeMoveWhenCellIsEmpty() {

        boolean result = board.placeMove(0, 0, 'X');

        assertTrue(result);
        assertEquals('X', board.getGrid()[0][0]);
    }

    @Test
    @DisplayName("placeMove should return false when cell is already occupied")
    void placeMoveWhenCellIsOccupied() {

        board.placeMove(0, 0, 'X');
        boolean result = board.placeMove(0, 0, 'O');

        assertFalse(result);
        assertEquals('X', board.getGrid()[0][0]);
    }

    @Test
    @DisplayName("placeMove should return false for out-of-bounds positions")
    void placeMoveWhenOutOfBounds () {

        assertFalse(board.placeMove(-1, 0, 'X'));
        assertFalse(board.placeMove(0, -1, 'X'));
        assertFalse(board.placeMove(3, 0, 'X'));
        assertFalse(board.placeMove(0, 3, 'X'));
    }

    @Test
    @DisplayName("placeMove should allow multiple valid moves")
    void placeMoveWhenMultipleValidMoves () {

        assertTrue(board.placeMove(0, 0, 'X'));
        assertTrue(board.placeMove(1, 1, 'O'));
        assertTrue(board.placeMove(2, 2, 'X'));

        assertEquals('X', board.getGrid()[0][0]);
        assertEquals('O', board.getGrid()[1][1]);
        assertEquals('X', board.getGrid()[2][2]);
    }
}