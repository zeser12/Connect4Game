package core;

import java.util.Random; /**
 * The object of the game Connect Four is to place colored
 * tokens onto a six-row, seven-column grid that is suspended vertically.
 * Players take turns selecting a color. The fragments fall vertically, taking
 * up the lowest point in the column. The aim of the game is to be the first player
 * to arrange four of their own tokens in a horizontal, vertical, or diagonal line.
 *
 *
 * @author Zeyneb Eser
 * @version 2.0
 * @since 03/22/2024
 */

public class Connect4Logic {

    char[][] board;

    /**
     * Constructor creates new board at 6x7 public int [][] board
     */
    public Connect4Logic() {
        board = new char[6][7];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * @return
     */
    public boolean isOver() {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == ' ') {
                return false; //means the spot is empty
            }
        }
        return true; //spot is occupied
    }

    /**
     * Print board method
     */
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.printf("|");
            for (int j = 0; j < board.length; j++) {
                System.out.printf("%c|", board[i][j]);
            }
            System.out.println();
        }
        for (int j = 0; j < board[0].length; j++) {
            System.out.printf("--");
        }
        System.out.println("-");
    }

    /**
     * Now, determine if the player X or O won the game.
     * adds pieces to the board
     *
     * @return
     */
    public boolean checkWinner() {

        //Create four boolean variables, it will be one for each set of rows.
        //Iniatilize the all four varibales to false
        boolean checkRow = false;
        boolean checkCol = false;
        boolean checkTLBRD = false;
        boolean checkTRBLD = false;

        //Check to see if four of the consecutive cells in a row match.
        //Check rows one by one
        for (int l = 0; l <= 5; l++) {
            for (int k = 0; k <= 3; k++) {
                if (board[l][k] == board[l][k + 1] && board[l][k] == board[l][k + 2] && board[l][k] == board[l][k + 3] && board[l][k] != ' ') {
                    checkRow = true;
                    break;
                }
            }
        }
        //Check if four columns in the same row match
        //Check columns one by one
        for (int l = 0; l <= 2; l++) {
            for (int k = 0; k <= 6; k++) {
                if (board[l][k] == board[l + 1][k] && board[l][k] == board[l + 2][k] && board[l][k] == board[l + 3][k] && board[l][k] != ' ') {
                    checkCol = true;
                    break;
                }
            }
        }
        //Check to see if four diagonals are matched
        //Check from top left to bottom right
        //Check major diagonals
        for (int l = 0; l <= 2; l++) {
            for (int k = 0; k <= 3; k++) {
                if (board[l][k] == board[l + 1][k + 1] && board[l][k] == board[l + 2][k + 2] && board[l][k] == board[l + 3][k + 3] && board[l][k] != ' ') {
                    checkTLBRD = true;
                    break;
                }
            }
        }
        //Check to see if four diagonals in the other direction match
        //Check from top right to bottom left
        //Check minor diagonals
        for (int l = 0; l <= 2; l++) {
            for (int k = 3; k <= 6; k++) {
                if (board[l][k] == board[l + 1][k - 1] && board[l][k] == board[l + 2][k - 2] && board[l][k] == board[l + 3][k - 3] && board[l][k] != ' ') {
                    checkTRBLD = true;
                    break;
                }
            }
        }
        //If one of the booleans is true, we have a winner.
        //Check is boolean for a true
        if (checkRow || checkCol || checkTLBRD || checkTRBLD) {
            return true;
        } else {
            return false;
        }
        //this is the end of checking for a winner
    }

    /**
     * @param player
     * @param column
     * @return
     */
    public boolean drop(char player, int column) {
        //getting O in the index base
        column--;
        if (column < 0 || column > 6) {
            throw new ArrayIndexOutOfBoundsException("There is an unmentioned coulmn to drop the disk");
        }
        boolean put = false;
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = player;
                put = true;
                break;
            }
        }
        return put;
    }
}

