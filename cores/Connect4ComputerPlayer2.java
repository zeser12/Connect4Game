package core;

//import ui.Connect4TextConcole;
/**
 * <li> Connect4TextConsole.java
 *<<li> Connect4ComputerPlayer.java
 */

//import java.util.Random;

/**
 * This class is a computer player for the Connect4 class.
 * @author Zeyneb Eser
 * @version 2.0
 */
//public class Connect4ComputerPlayer extends Connect4TextConcole {
//    private int compMove;
 //   public void Connect4ComputerPlayer() {
 //       Random rand = new Random();
  //      compMove = rand.nextInt(7);
  //      System.out.println("Computer selected column " + (compMove + 1) + ".");
  //  }

  //  public int getCompCol()
  //  {
  //      return compMove;
  //  }
//}



import ui.Connect4TextConcole;

import java.util.Random;

public class Connect4ComputerPlayer extends Connect4TextConcole {
    /**
     * Generate a valid move for the computer player.
     * @param board The current state of the game board.
     * @return The column where the computer player wants to drop its piece.
     */
    public static int generateMove(char[][] board) {
        Random rand = new Random();
        int column;
        do {
            column = rand.nextInt(7); // Generate a random column index (0-6)
        } while (!isValidMove(board, column));

        return column + 1; // Convert column index to column number (1-7)
    }

    /**
     * Check if a move is valid for the computer player.
     * @param board The current state of the game board.
     * @param column The column where the computer player wants to drop its piece.
     * @return True if the move is valid, false otherwise.
     */
    private static boolean isValidMove(char[][] board, int column) {
        if (column < 0 || column >= board[0].length) {
            return false; // Column index out of bounds
        }
        // Check if the top row of the selected column is empty
        return board[0][column] == ' ';
    }
}










