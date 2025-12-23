import java.util.ArrayList;

public class ActivelySelectionSorted{
    public static void main(String[] args){

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        ArrayList<Integer> selectedActivities = new ArrayList<>();

        int activitycounter = 0;

        /*
        * activity selection starts....
        * the first activity always gets selected
        */ 
        
        selectedActivities.add(0);
        activitycounter = 1; // increasing the counter for the first activity
        int lastSelectedActivity = end[0];

        for(int i=1; i<end.length; i++){
            if(start[i] >= lastSelectedActivity){
                selectedActivities.add(i);
                activitycounter++;
                lastSelectedActivity = end[i];
            }
        }

        System.out.println("\n-------- Max-activities :" + activitycounter);
        for(int i=0; i<selectedActivities.size(); i++){
            System.out.print("-------- A"+selectedActivities.get(i) + " ");
        }
    }
}