// Time Complexity :- O(n^2)
// Space Complexity :- O(1)

/*
Best Case Omega(n^2):
    Still compares every element to find the minimum, regardless of order.

Average Case Theta(n^2):
    Number of comparisons remains the same for random input.

Worst Case O(n^2):
    Even in reverse order, the algorithm performs full scans each time.
 */

package Array.Sorting;

import java.util.Arrays;

public class SelectionSort {
    static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int min_idx = i;

            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min_idx]){
                    min_idx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}