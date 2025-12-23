import java.util.Scanner;
import java.util.ArrayList;

public class multi_dimArrayList {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // updating the list1
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        // updating the list2
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);

        // updating the list3
        list3.add(3);
        list3.add(6);
        list3.add(9);   
        list3.add(12);
        list3.add(15);

        // adding the list1, list2, and list3 to the mainList
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        // printing the mainList
        System.out.println(mainList);

        // printing the list1, list2, and list3
        for(int i=0; i<mainList.size(); i++){
            ArrayList<Integer> currentList = mainList.get(i);
            for(int j=0; j<currentList.size(); j++){
                System.out.print(currentList.get(j) + " ");
            }
            System.out.println();
        }
    }
}
