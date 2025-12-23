import java.util.Scanner;
import java.util.ArrayList;

/*
 * MostWater.java
 * -----------------------------
 * Problem: Container With Most Water
 * Given an array of heights representing vertical lines on the x-axis,
 * find two lines that, together with the x-axis, form a container that can store the maximum amount of water.
 *
 * Approach:
 * - Use a brute force approach by checking all possible pairs of lines.
 * - For each pair, calculate the area formed and track the maximum.
 * - Area = min(height[i], height[j]) * (j - i)
 *
 * Time Complexity: O(n^2)  -> because of the nested loops
 * Space Complexity: O(1)   -> constant space used
 */

public class MostWater {

    // Function to calculate the maximum area (water) that can be stored
    public static int storeWater(ArrayList<Integer> height){
        int maxArea = 0; // stores the max area found so far
        int length = 0, breadth = 0; // temporary variables to hold height and width for each pair

        // Loop over all pairs of indices
        for(int i = 0; i < height.size(); i++){
            for(int j = i + 1; j < height.size(); j++){
                // Find the limiting height (the shorter line)
                length = Math.min(height.get(i), height.get(j));
                // Calculate distance between the two lines
                breadth = Math.abs(j - i);
                // Calculate the area and update maxArea if this is greater
                maxArea = Math.max(maxArea, length * breadth);
            }
        }
        return maxArea; // return the largest area found
    }

    public static void main(String[] args){
        // Create an ArrayList to store the heights of lines
        ArrayList<Integer> height = new ArrayList<>();

        // Sample input: heights of vertical lines
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // Call the function and print the result
        System.out.println("The maximum stored water : " + storeWater(height));
    }    
}
