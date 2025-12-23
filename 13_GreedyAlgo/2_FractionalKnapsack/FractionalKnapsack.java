import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack{

    public static void printArray(double[][] activities, int start_size){
        for(int i=0;i<start_size; i++){
            for(int j=0; j<3; j++){
                System.out.print(activities[i][j] + "  ---  ");
            }
            System.out.println();
        }
        return;
    }
    public static void main(String[] args){
        
        // input data
        int[] wt = {10, 20, 30};
        int[] value = {60, 100, 120};
        double capacity = 50;

        /*
         * Calculating the ratio value/wt
         * this is becoz, i want the maximum value in the Knapsack
         * " their can be fractional portion "
         * 
         * The 2D[][] will contians ratio | wt | value in the sorted form
         */

        double [][] ratio = new double[value.length][3];
        for(int i=0; i<value.length; i++){ // populating the 2D[][]
            ratio[i][0] = (double)value[i]/wt[i]; // ratio
            ratio[i][1] = wt[i]; // weight of the items
            ratio[i][2] = value[i]; // value of the items
        }

        // sorting the 2D[][] w.r.t. value
        Arrays.sort(ratio, (a,b) -> Double.compare(b[0], a[0]));
        
        // Printing the 2D[][]
        printArray(ratio, value.length);
        double profit = 0;
        for(int i=0; i<value.length; i++){
            if(capacity >= ratio[i][1]){
                capacity-=ratio[i][1]; // reducing the capacity value by the wt value
                profit += ratio[i][2]; // increasing the profit
            }else{
                profit += ratio[i][0] * capacity; 
                break;
            }
        }

        System.out.println("The profit earn --> " + profit);
    } 
}