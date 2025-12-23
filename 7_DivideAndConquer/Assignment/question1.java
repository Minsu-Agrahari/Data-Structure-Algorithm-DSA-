public class question1 {

    public static vodi Merge(String arr[], int si, int mid, int ei){
        String temp[] = new String[ei - si + 1];

        // intiziation of index
        int i = si;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= ei){
            
        }
    }

    public static void Merge_sort(String arr[], int si, int ei){
        if(si > ei) return;

        int mid = si + (ei - si)/2;

        Merge_sort(arr, si, mid);
        Merge_sort(arr, mid+1, ei);

        Merge(arr, si, mid, ei);
    }

    public static void display(String arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String arr[] = {"sun", "earth", "mars", "mercury"};
        display(arr);
        Merge_sort(arr, 0, arr.length-1);
        display(arr);
    }
}
