package array;

public class subarray {

    //subarray
    public static void subarray(int arr[]){
        for(int i=0; i<arr.length; i++){
            int start=i;
            for(int j=i; j<arr.length; j++){
                int end = j;
                for(int k= start; k<end; k++){
                    System.out.print(arr[k]+",");
                }
                System.out.println();
            }
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
        print_arr(arr);
        subarray(arr);
    }
}
