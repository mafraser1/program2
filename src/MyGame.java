/*
 * Author: Maxwell Fraser
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */

import java.util.Scanner;

public class MyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        //Makes a new game until the players decide not to play again
        int playAgain = 1;
        while (playAgain == 1) {
            C4 connectFour = new C4();
            System.out.println("Welcome to Connect 4!\n");
            //This loop allows players to play this round until a winner is found
            while (connectFour.isWinner() == false) {
                connectFour.printBoard();
                System.out.println("Player " + connectFour.getTurn + "'s Turn."
                        + "\nSelect a collumn to drop your piece.");
                connectFour.playPiece(kb.nextInt(), connectFour.getTurn());
                //If a winner is found it gives a message and asks if they want to play again
                if (connectFour.isWinner()) {
                    System.out.println("Congratulations! Player "
                            + connectFour.getTurn() + " Wins!");
                    System.out.println("Would you like to play again?(Enter '1' "
                            + "to play again. Any other key to exit");
                    playAgain = kb.nextInt();                    
                } 
                //Otherwise it switches the players turns
                else {
                    connectFour.nextTurn();
                }
            }
        }

    }

}
