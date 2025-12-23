/*
 * Min Absolute Difference Pairs
 * Given two Arrays A and B of equal length n. Pair each element
 * of array A to an element in array B, such that sum S of absolute
 * differences of all the pairs in minimum.
 */

 // time complexity :- O(Nlog(N))
 // Space complexity :- O(N)
import java.util.Arrays;
import java.util.Comparator;

public class MinAbsoluteDiffPair {
    public static void printArray(int[][] arr, int a_size){
        for(int i=0;i<a_size; i++){ //-------------------------------------------O(N)
            for(int j=0; j<3; j++){ //-------------------------------------------O(3)
                System.out.print(arr[i][j] + "  ---  ");
            }
            System.out.println();
        }
        return;
    }
    public static void main(String[] args) {

        // Given input :- 
        int[] a = {4, 8, 1, 7};  
        int[] b = {2, 3, 6, 5}; 

        // sorting the array a and b
        Arrays.sort(a); // ------------------------------------O(Nlog(N))
        Arrays.sort(b); //-------------------------------------O(Nlog(N))

        /* 
         * A 2D[][] array stores the sorted values of a and b(input arrays), with their 
         * absoulte different
         * storing structure :- a | b | absoulteDifferent
         */
        int [][] minDiff = new int[a.length][3];

        // populating the minDiff
        for(int i=0; i<a.length; i++){ //-----------------------O(N)
            minDiff[i][0] = a[i];
            minDiff[i][1] = b[i];
            minDiff[i][2] = Math.abs(a[i]-b[i]);
        }

        //printing the minDiff array
        printArray(minDiff, a.length);

        // Minimum Absolute Different Pair
        int minAbsoluteDiff = 0; 
        for(int i=0; i<a.length; i++){ //-----------------------O(N)
            minAbsoluteDiff += minDiff[i][2];
        }

        System.out.println("The minimum Absolute Different Pair :- "+ minAbsoluteDiff);
    }
}
