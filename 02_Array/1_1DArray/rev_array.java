package array;

// input  :- 1 2 3 4 5
// output :- 5 4 3 2 1

import java.util.Scanner;
public class rev_array {

    //reverse the element in the array
    public static void reverse_array(int arr[]){
        int start = 0, end = arr.length-1;
        while(end>start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start ++;
            end--;
        }
    }
    //print the array
    public static void print_arr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //main function
        public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5};
            print_arr(arr);
            reverse_array(arr);
            print_arr(arr);
    }
}
