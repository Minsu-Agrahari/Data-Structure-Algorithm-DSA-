// Time Complexity :- O(nlogn)
// Space Complexity :- O(n)

/*
Best Case Omega(n log(n)):
    The array is always divided into halves regardless of order

Average Case Theta(n log(n)):
    Merging two sorted halves always takes linear time per level

Worst Case O(n log(n)):
    Input order does not affects divide-and-conquer behavior.
 */
package Array.Sorting;

import java.util.Arrays;

public class MergeSort {

    static void merge(int[] arr, int start, int mid, int end){

        // size of 2 subarrays
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // creating temp arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // copy data to temp arrays
        System.arraycopy(arr, start, leftArr, 0, n1);
        System.arraycopy(arr, mid+1, rightArr, 0, n2);

        // merge the temp arrays
        int i=0, j=0;
        int k=start;

        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        // copy the remaining leftArr[]
        while(i < n1){
            arr[k++] = leftArr[i++];
        }

        // copy the remaining rightArr[]
        while(j < n2){
            arr[k++] = rightArr[j++];
        }
    }

    static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + (end - start) / 2;

            // sort first halve
            mergeSort(arr, start, mid);
            // sort second halve
            mergeSort(arr, mid+1, end);

            merge(arr, start, mid, end);
        }
    }

    static void main(String[] args) {
        int[] arr = {38, 27, 43, 10};

        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}