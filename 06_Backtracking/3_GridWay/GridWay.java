/* A recursive method to find the total number of ways to reach the bottom-right corner of the grid from a 
* given start point(x, y). 
* It recursively explores two possible moves at each point: moving right or down. 
* It uses base cases to stop recursion when it reaches the destination or goes out of bounds.
*/

import java.util.Scanner;

public class GridWay {

    // Recursive function to find the total number of ways to reach the destination (n-1, m-1)
    public static int GridWays(int x, int y, int n, int m){
        
        // Base case: If the current position is the destination (bottom-right corner)
        if(x == n-1 && y == m-1) return 1; // Reached the destination
        
        // Base case: If the current position is out of bounds
        if(x >= n || y >= m) return 0; // Out of bounds, return no way

        // Recursive call: Move right (increase y)
        int way1 = GridWays(x, y+1, n, m); 

        // Recursive call: Move down (increase x)
        int way2 = GridWays(x+1, y, n, m); 

        // Return the total ways from this cell by summing both directions (right and down)
        return way1 + way2; 
    }

    public static void main(String[] args) {
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
        System.out.println("Total ways to reach the destination: " + GridWays(x, y, n, m));
    }
}
