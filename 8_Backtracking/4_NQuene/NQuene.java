/*** Time complexity :- O(N!)
 * Space complexity :- O(N^2)
 * N-Queens Problem using Backtracking
 * N-Queens Problem is a classic problem in computer science and combinatorial optimization. The goal is to place
 * N queens on an N x N chessboard such that no two queens threaten each other. This means that no two queens can be in the same row, column, or diagonal.
 * The solution involves using backtracking to explore all possible placements of queens on the board. The algorithm starts by placing a queen in the first row and then recursively attempts to place queens in subsequent rows while checking for conflicts. If a conflict is detected, the algorithm backtracks and tries a different placement until all queens are successfully placed or all possibilities are exhausted.
*/ 
 import java.util.Scanner;

public class NQuene {
    static int counter = 0;

    // check the vaild possition place for quene
    public static boolean isSafe(char[][] board, int row, int col){
        // vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // right diagonal
        for(int i=row, j = col; i>=0 && j<board.length ; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // left diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;

    }
    // Printing all the possible position for the NQuene
    public static void possiblePlaces(char[][] board, int row){

        if(board.length == row){
            printBoard(board);
            counter ++;
            return;
        }

        for(int i=0; i<board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                possiblePlaces(board, row+1);
                board[row][i] = 'x';
            }
        }
    }

    // print() -> to print the eniter chess board
    public static void printBoard(char[][] board){

        System.out.println("------------Chess Board -------------");

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }
   
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the size of the Chess Board :- ");
        int size = in.nextInt();
        

        //creating a 2D chess board
        char[][] chessBoard = new char[size][size];

        // creating a Chess Board
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                chessBoard[i][j] = 'x';
            }
        }

        // printing the chess board
        possiblePlaces(chessBoard, 0);
        System.out.println("Total number of possible places for NQuene is : " + counter);   
    }
}
