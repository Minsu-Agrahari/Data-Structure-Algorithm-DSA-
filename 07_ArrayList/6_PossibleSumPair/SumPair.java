import java.util.ArrayList;
import java.util.Scanner;

public class SumPair {

    // Function to find the first pair of numbers that sum up to the target
    public static ArrayList<Integer> findSumPair(ArrayList<Integer> arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        // Brute force approach: check all pairs
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) + arr.get(j) == target) {
                    result.add(arr.get(i));
                    result.add(arr.get(j));
                    return result;  // Return on first match
                }
            }
        }

        return null;  // No pair found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        // Adding sample values (this can be improved by taking input from user)
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        ArrayList<Integer> result = findSumPair(arr, target);

        // Output the result
        if (result != null) {
            System.out.println("Pair found: " + result.get(0) + ", " + result.get(1));
        } else {
            System.out.println("No pair found with the given target sum.");
        }
    }
}

/*
 Description:
This program finds the first pair of integers in an ArrayList that sum up to a given target.
It uses a brute-force approach by checking all possible pairs in nested loops.

 Time Complexity: O(n^2) due to two nested loops
 Space Complexity: O(1) excluding output space

 Note:
- Returns only the first pair found.
- Can be optimized using HashMap to get O(n) time.
*/
