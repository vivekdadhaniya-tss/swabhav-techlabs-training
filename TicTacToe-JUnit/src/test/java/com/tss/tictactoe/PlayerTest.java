package com.tss.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void createPlayerTest() {
        Player player = new Player("Vivek", 'X');

        assertEquals("Vivek", player.getName());
        assertEquals('X', player.getSymbol());
    }

}