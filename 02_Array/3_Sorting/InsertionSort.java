// Time Complexity :- O(n^2)
// Space Complexity :- O(1)

/*
Best Case Omega(n) :
    When the array is already sorted, each element is compared once and placed directly

Average Case Theta(n^2)
    Elements are randonmly ordered, requiring shifting of elements for each insertion.

Worst Case O(n^2)
    When the array is reverse sorted, each new element must be shifted across the entire sorted portion
 */
package Array.Sorting;
import java.util.Arrays;

public class InsertionSort {
    static void insertionSort(int[] arr){

        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }

    }

    static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
