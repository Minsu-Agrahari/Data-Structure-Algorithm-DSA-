/*
Best Case : omega(n)
    Occurs when array is already sorted. No swaps happend, so the algo terminates early using the swapped flag

Average Case : Theta(n^2)
    Elements are in random order, requiring multiple passes and comparisons

Worst Case : O(n^2)
    Happens when the array is reverse sorted. Every pair needs to be compared and swapped
 */

package Array.Sorting;

import java.util.Arrays;

public class BubbleSort {
    static void main(String[] args) {

        int[] arr = {4, 5, 6, 1, 3, 0 , 9};
        boolean swapped;

        for(int i=0; i<arr.length-1; i++){
            swapped = false;
            for(int j=0; j<arr.length-i-1; j++){

                if(arr[j] < arr[j+1]){

                    // swapping
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }

            }
            if(!swapped) break;
        }

        System.out.println(Arrays.toString(arr));
    }
}
