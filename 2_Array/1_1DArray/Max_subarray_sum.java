package array;

import java.util.*;

public class Max_subarray_sum {

    //BEST APPROACH TO FIND THE SUM OF THE MAXIMUM SUBARRAY
    //TIME_COMPLEXITY :- O(n)
    //KADAEN'S ALGORITHM 

    public static void KADAENS_max_subarray_sum(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int curr_sum = 0;
        
        //CHECK IF THE GIVEN SET OF ELEMENT ARE POSITIVE OR NEGATIVE

        int count_negative = 0;
        for(int i=0 ; i<arr.length; i++){
            if(arr[i] < 0){
                count_negative++;
            }else{
                count_negative--;
            }
        }
        if(count_negative == arr.length){
            System.out.println("!!! THE GIVEN SET OF ELEMENT ARE NEGATIVE !!!");
        }else{
            System.out.println("!!! IN THE GIVEN SET OF ELEMENT THERE IS POSITIVE ELEMENT PRESENT !!! ");
        }


        // !!! IN THE GIVEN SET OF ELEMENT THERE IS POSITIVE ELEMENT PRESENT !!!

        if(count_negative != arr.length){

            for(int i=0; i<arr.length; i++){
                curr_sum = curr_sum + arr[i];
                if(curr_sum < 0){
                    curr_sum = 0;
                }
                    maxSum = Math.max(curr_sum, maxSum);
            }
            System.out.println(maxSum);

        }else{
            for(int i=0; i<arr.length; i++){
                maxSum = Math.max(maxSum, arr[i]);
            }
            System.out.println(maxSum);
        }
        
    }


    // AVERAGE APPROACH TO FIND THE SUM OF THE MAXIMUM SUBARRAY
    // TIME COMPLEXITY :- O(n2)
    
    public static void average_apporach(int arr[]){

        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int prefix []= new int [arr.length];

        //prefix 0th index will be same that of arr 0th index
        prefix[0] = arr[0];

        //calculate the perfix array
        for(int i=1; i<arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        //comparsion of the element 
        
        for(int i=0; i<arr.length; i++){
            int start = i;
            for(int j=i; j<arr.length; j++){
                int end = j;
                int curr_sum =0;
                if (start == 0){
                    current_sum = prefix[end];
                }else{
                    current_sum = prefix[end] - prefix[start-1];
                }

                if(current_sum > max_sum){
                    max_sum = current_sum;
                }
            
            }
        }
        
        System.out.println(max_sum );
    }


    //BRUTH-FORCES APPROACH 
    // TIME COMPLEXITY = O(n3)
    
    public static void subarray_sum(int arr[]){
        int curr_sum=0;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int start=i;
            for(int j=i; j<arr.length; j++){
                int end = j;
                curr_sum =0;
                for(int k= start; k<=end; k++){
                    curr_sum+=arr[k];
                }
                    System.out.print(curr_sum+" , ");
                if(curr_sum > max_sum){
                    max_sum = curr_sum;
                }
            }
        }
        System.out.println("\n"+max_sum);
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
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println("!!! BRUTH_FORCE APPROACH !!!");
        print_arr(arr);
        subarray_sum(arr);

        System.out.println("!!! AVERAGE APPROACH !!!");
        print_arr(arr);
        average_apporach(arr);

        System.out.println("!!! KADAEN'S ALGORITHIM !!!");
        print_arr(arr);
        KADAENS_max_subarray_sum(arr);
    }
}
