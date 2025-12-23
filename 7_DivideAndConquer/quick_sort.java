public class quick_sort {

    public static void Display(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i=si-1;

        for(int j=si; j<ei; j++){
            i++;
            // swap 
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] =temp;
        }

        // swapping the pivot element
        i++;
        // swap 
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] =temp;
        return i;
    }

    public static void quicksort(int arr[], int si, int ei){
        //base case
        if(si >= ei) return;

        int pIdx = partition(arr, si, ei); // last element 
        quicksort(arr, si, pIdx-1); // left
        quicksort(arr, pIdx+1, ei); // right
    }
    public static void main(String[] args) {
        int arr[] = {8, 21, 12, 10, 50, 72, 35, 81};
        quicksort(arr, 0, arr.length-1);
        Display(arr);
    }
}
