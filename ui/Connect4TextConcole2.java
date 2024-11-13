
/**
 * UI contains the Connect4TextConsole.java file
 * This class is the user UI and for the Connect4 GUI
 * @ version 2.0
 * @ Author Zeyneb Eser
 */

package ui;
import java.util.Scanner;
import core.Connect4Logic;

public class Connect4TextConcole {
    /**
     * User interface for Connect 4 The main method that launches the GUI return void
     *
     * @param args
     */
    public static void main(String[] args) {
        Connect4Logic game = new Connect4Logic();

        //turn false means Player 'X'
        boolean turn = true;
        Scanner scan = new Scanner(System.in);

        do {
            turn = !turn;
            game.printBoard();
            char player;

            if (turn) {
                player = 'o';
            } else {
                player = 'X';
            }
            System.out.print("Player" + player + "-your turn. Choose a column (1-7):");
            boolean status = false;
            while(!status) {
                try {
                    status = game.drop(player, scan.nextInt());
                    if (!status) {
                        System.out.println("Could not play. Invalid position or position is already filled.");
                        System.out.print("Try again: ");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    System.out.print("Try again!");
                    scan.nextInt(); //clear buffer
                }
            }
            System.out.println();
        } while (!game.isOver() && !game.checkWinner());
        game.printBoard();
        if (game.checkWinner()) {
            System.out.printf("The %s player has won!", (turn ? "o" : "X"));
        } else {
            System.out.println("Game is Over");
        }
        scan.close();
    }
}



