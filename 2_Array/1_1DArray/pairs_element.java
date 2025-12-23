package array;

// input  :- 1 2 3 4 5
// output :-(1,2) -- (1,3) -- (1,4) -- (1,5) -- 
//          (2,3) -- (2,4) -- (2,5) --
//          (3,4) -- (3,5) --
//          (4,5) --

//          1 2 3 4 5
import java.util.Scanner;
public class pairs_element {

    //pair collector
    public static void pair_collecter(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                System.out.print("("+arr[i]+","+arr[j]+") -- ");
            }
            System.out.println();
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
    public static void main(String args[]){
        int arr[] = { 1, 2, 3, 4, 5};
        pair_collecter(arr);
        print_arr(arr);
    }
}
