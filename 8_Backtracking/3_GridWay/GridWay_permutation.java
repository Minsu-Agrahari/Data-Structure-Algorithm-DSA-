/*
This Java program calculates the number of unique paths from a starting point (x, y) to the destination (n-1, m-1) 
in a grid of size n x m. 
It uses a permutation formula to determine the total number of ways to move right and down in the grid. 
The factorial of numbers is calculated using a recursive function.
*/
import java.util.Scanner;

public class GridWay_permutation {

    // Recursive function to calculate the factorial of a number 'n'
    public static int factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) return 1;

        // Recursive case: factorial of n is n * (n-1)!
        return n * factorial(n - 1);
    }

    // Function to calculate the number of unique paths from point (x, y) to the destination (n-1, m-1)
    public static int permutation(int x, int y, int n, int m) {
        // Calculate the remaining number of rows and columns to reach the destination
        int n1 = n - x - 1; // Remaining rows to move down
        int m1 = m - y - 1; // Remaining columns to move right

        // The total number of unique paths is given by the permutation formula:
        // (n1 + m1) choose (n1) -> which is (n1 + m1)! / (n1! * m1!)
        int totalMoves = factorial(n1 + m1) / (factorial(n1) * factorial(m1));

        return totalMoves; // Return the total number of unique paths
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Input grid size (N x M)
        System.out.println("Enter the grid size (N): ");   
        int n = in.nextInt();
        System.out.println("Enter the grid size (M): ");
        int m = in.nextInt();

        // Input starting point (x, y)
        System.out.println("Enter the starting point (x, y): ");
        int x = in.nextInt();
        int y = in.nextInt();

        // Calculate and print the total number of ways to reach the destination
        System.out.println("Total ways to reach the destination: " + permutation(x, y, n, m));
    }
}
