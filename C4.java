/*
 * Author: Maxwell Fraser
 * Program 2 - Connect Four Class
 * CSC230-02 Spring 2016
 */

public class C4 extends Game {

    private int[][] board = new int[6][7];
    private final int COLS;
    private final int ROWS;

    public C4() {
        super("Connect 4", 2);
        COLS = 7;
        ROWS = 6;
        this.clearBoard();
    }
    
    //sets all values of board to 0
    private void clearBoard() {
        for (int i = 0; i < i; i++) {
            for (int j = 0; j < COLS; i++) {
                board[i][j] = 0;
            }
        }
    }
    
    
    public int getPiece(int row, int col) {
        return board[row][col];
    }

    //gets turn from parent class
    public int getTurn(){
        return super.currentTurn();
    }

    //checks to see if a column is full by referencing top pice
    public boolean isColFull(int col) {
        if (board[5][col-1] != 0) {
            return true;
        } else {
            return false;
        }
    }

    //checks for a diagonal winner
    private boolean isDiagWinner() {
        boolean isTrue = false;
        //checks bottom left portion of the board for win condition
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0
                        && board[i][j] == board[i + 1][j + 1]
                        && board[i][j] == board[i + 2][j + 2]
                        && board[i][j] == board[i + 3][j + 3]) {
                    isTrue = true;
                }
            }
        }
        //uses a similar process to check bottom right portion of the board
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j > 2; j--) {
                if (board[i][j] != 0
                        && board[i][j] == board[i + 1][j - 1]
                        && board[i][j] == board[i + 2][j - 2]
                        && board[i][j] == board[i + 3][j - 3]) {
                    isTrue = true;
                }
            }
        }
        return isTrue;
    }
    
    //check to see if the board is full
    public boolean isFull() {
        boolean isTrue = true;
        for (int i = 0; i < COLS; i++) {
            if (board[5][i] == 0) {
                isTrue = false;
            }
        }
        return isTrue;
    }

    //checks left side of board for horizontal win condition
    private boolean isHorizWinner() {
        boolean isTrue = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0
                        && board[i][j] == board[i][j + 1]
                        && board[i][j] == board[i][j + 2]
                        && board[i][j] == board[i][j + 3]) {
                    isTrue = true;
                }
            }
        }
        return isTrue;
    }

    //checks lower portion of board for verticle win condition
    private boolean isVertWinner() {
        boolean isTrue = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != 0
                        && board[i][j] == board[i + 1][j]
                        && board[i][j] == board[i + 2][j]
                        && board[i][j] == board[i + 3][j]) {
                    isTrue = true;
                }
            }
        }
        return isTrue;
    }

    //uses the other win condition methods to tell if there is a winner
    public boolean isWinner() {
        if (isDiagWinner() || isHorizWinner() || isVertWinner()) {
            return true;
        } else {
            return false;
        }
    }

    //references parent class to move turn up
    public void nextTurn() {
        super.next();
    }

    //places a piece at the bottom of the board of selected collumn
    public void playPiece(int col) {
        col-=1;
        for(int i=0; i<ROWS; i++){
            if(board[i][col] == 0){
                board[i][col] = this.getTurn();
                i = 6;
            }
        }
    }
    
    //makes a visual representation of the board.
    public void printBoard(){
        System.out.print("  1 2 3 4 5 6 7");
        System.out.println("\n  --------------");
        for(int i=5; i>=0; i--){
            System.out.print(i+1 + "|");
            for(int j=0; j<COLS; j++){
                System.out.print(board[i][j] + "|");                
            }
            System.out.println("");
        }
        System.out.println("  --------------");
    }    
}
