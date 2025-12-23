import java.util.*;
public class Merge_sort{
    
    public static void Merge(int arr[], int si, int mid, int ei){
        
        // temp array
        int temp [] = new int[ei-si+1];

        // initization of idx's
        int i=si; // iterator for left part
        int j=mid+1; // iterator for right part
        int k=0; // iterator for temp arr

        while(i<=mid && j<=ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // right remaining part
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        // left remaining part
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        // copy the remaining temp to the original array
        for(i = si, k = 0;  k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void Merge_sort(int arr[], int si, int ei){
        if(si >= ei) return;
        
        int mid = si + (ei - si)/2;

        Merge_sort(arr, si, mid);
        Merge_sort(arr, mid+1, ei);
        Merge(arr, si, mid, ei);
    }

    public static void Display(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {8, 21, 12, 10, 50, 72, 35, 81};
        Merge_sort(arr, 0, arr.length-1);
        Display(arr);
    }
}