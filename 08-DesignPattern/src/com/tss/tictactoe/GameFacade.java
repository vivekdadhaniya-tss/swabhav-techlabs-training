package com.tss.tictactoe;

import java.util.Scanner;

public class GameFacade {

    private Board board;
    private Player player1;
    private Player player2;
    private GameValidator validator;
    private Scanner scanner;

    public GameFacade() {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        validator = new GameValidator();
        scanner = new Scanner(System.in);
    }

    public void startGame() {

        Player currentPlayer = player1;
        int moves = 0;

        while (true) {
            board.printBoard();

            System.out.println(currentPlayer.getName() + " enter row and column (0-2): ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            if (row < 0 || row > 2 || column < 0 || column > 2) {
                System.out.println("Invalid position! Enter values between 0 and 2.");
                continue;
            }

            if (!board.placeMove(row, column, currentPlayer.getSymbol())) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            moves++;

            if (validator.checkWin(board.getGrid(), currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (moves == 9) {
                board.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
