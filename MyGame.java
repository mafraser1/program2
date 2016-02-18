/*
 * Author: Maxwell Fraser
 * Program 2 - MyGame-main
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
            while (connectFour.isWinner() == false
                    || connectFour.isFull() == false) {
                connectFour.printBoard();
                System.out.println("Player " + connectFour.getTurn() + "'s Turn."
                        + "\nSelect a collumn to drop your piece.");
                int col = kb.nextInt();
                boolean colOk = false;
                //checks to see if the players input is valid
                while (colOk == false) {
                    if (col > 7 || col <= 0) {
                        System.out.println("There is no Colulmn #" + col
                                + "\nPlease Choose a column between 0 and 6");
                        col = kb.nextInt();
                    }
                    //checks to see if the collumn the player chose is full
                    if (connectFour.isColFull(col)) {
                        System.out.println("This column is already full."
                                + "\nPlease select a different column");
                        col = kb.nextInt();
                    } else {
                        colOk = true;
                    }
                }
                connectFour.playPiece(col);
                //If a winner is found it gives a message and asks if they want to play again
                if (connectFour.isWinner()) {
                    connectFour.printBoard();
                    System.out.println("Congratulations! Player "
                            + connectFour.getTurn() + " Wins!");
                    System.out.println("Would you like to play again?(Enter '1' "
                            + "to play again. Any other key to exit");
                    playAgain = kb.nextInt();
                }
                
                if (connectFour.isFull()){
                    System.out.println("The board is full. Draw Game!");
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
