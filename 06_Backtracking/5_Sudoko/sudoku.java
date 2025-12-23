import java.util.Scanner;

/*
 * Sudoku Solver using Backtracking
 * --------------------------------
 * This program solves a given 9x9 Sudoku puzzle using backtracking.
 * The board is filled such that each row, column, and 3x3 grid contains all digits from 1 to 9 exactly once.
 * 
 * Key Concepts:
 * - Uses recursion to try placing digits in empty cells (0).
 * - Before placing a digit, it checks whether placing it is safe (i.e., not violating Sudoku rules).
 * - If the current path fails to produce a solution, it backtracks and tries the next possibility.
 */

public class sudoku {

    // Function to check whether placing a digit at (row, col) is valid
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        // Safe to place the digit
        return true;
    }

    // Recursive function to solve Sudoku using backtracking
    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        // Base Case: If we reach past the last row, the board is solved
        if (row == 9) {
            return true;
        }

        // Compute next cell
        int nextRow = row;
        int nextCol = col + 1;

        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If current cell is already filled, skip to next
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // Try placing digits 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit; // Place digit
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true; // If solution found, return true
                }
                sudoku[row][col] = 0; // Backtrack
            }
        }

        // No valid digit found for this cell
        return false;
    }

    // Function to print the solved Sudoku board
    public static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };

        // Solve and display the result
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists:");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution does not exist.");
        }
    }
}
