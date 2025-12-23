/*
Best Case -- Omega(1)
    The best case occurs when the target element is exactly at the middle position of the array.
    Only one comparison is needed, so the search finishes immediately.

Average Case -- Theta(log(n))
    On Average, the target lies somewhere in the array and each comparison reduces the search space by half.
    This repeated halving results in logarithmic time complexity.

Worst Case -- O(log(n))
    The worst case occurs when the element it not present or is found at the last possible step.
    The algorithm still keeps dividing the array in half untill the search space become empty.
 */

package Array.Sorting.Searching;

public class BinarySearch {

    static boolean binarySearch(int[]arr, int key){

        int start = 0, end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == key) return true;
            else if(arr[mid] > key) end = mid-1;
            else start = mid+1;
        }

        return false;
    }
    static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 8, 10};
        int key = 5;

        System.out.println(binarySearch(arr, key));
    }
}
