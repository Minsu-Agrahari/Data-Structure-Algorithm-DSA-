/*
 * Time complexity: O(n) 
 * Space complexity: O(1) 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class swap2num {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("\n Orginal list: ");
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }System.out.println("\n----------------------------------\n");

        System.out.println("Enter the index to two elements to swap: ");
        Scanner sc = new Scanner(System.in);
        int idx1 = sc.nextInt();
        int idx2 = sc.nextInt();

        // swap the elements at the given indices
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

        // print the swapped list
        System.out.println("Swapped list: ");
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\n----------------------------------\n");
    }
    
}
