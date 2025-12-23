import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionUnSorted {

    public static void printArray(int[][] activities, int start_size){
        for(int i=0;i<start_size; i++){
            for(int j=0; j<3; j++){
                System.out.print(activities[i][j] + "  ---  ");
            }
            System.out.println();
        }
        return;
    }
    public static void main(String[] args){
        
        // taking the unsorted activities as an input with --starting and --ending time
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        /* 2D array to store index | start-time | end-time 
         * the eniter 2D array will be sorted on the basis of end time
         * using Collections class and Lambda expression
         */

        int[][] activities = new int[start.length][3];
        for(int i=0; i<start.length; i++){ // populating the 2D[][] --- activities
            activities[i][0] = i; // index
            activities[i][1] = start[i]; // starting values
            activities[i][2] = end[i]; // ending values
        }

        // storting the activities 2D array uisng lambda expression
        Arrays.sort(activities, Comparator.comparingDouble(o->o[2]));

        // priniting the 2D[][] for view
        printArray(activities, start.length);

        // ArrayList to store the selected activities
        ArrayList<Integer> selectedActivity = new ArrayList<>();

        int MaxActivity_Counter = 0;
        int lastSelectedActivity = activities[0][0];

        // since, activity is selected that the ---<< MaxActivity_Counter >>--- will increase 
        selectedActivity.add(activities[0][1]); // adding the activity to the arrayList
        MaxActivity_Counter++;

        // since, the first Activity is selected so the operation for selecting 
        // maximum number of activity much start from 1 
        for(int i=1; i<end.length; i++){
            if(activities[i][1] >= lastSelectedActivity){
                MaxActivity_Counter++;
                selectedActivity.add(activities[i][1]);
                lastSelectedActivity = activities[i][1];
            }
        }

        System.out.println("MaxActivity :- "+MaxActivity_Counter);

        // printing the selected Activity
        System.out.println("The Selected Activity --- ");
        for(int i=0; i<selectedActivity.size(); i++){
            System.out.print("A"+selectedActivity.get(i)+", "); 
        }
    }
}