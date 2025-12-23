/*
 * Time complexity: O(n)
 * space complexity: O(1)
 * This code reverses an ArrayList of integers.
 */

import java.util.ArrayList;

public class ReverseArrayList {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for(int i=list.size()-1; i>=0; i--){
            System.out.println(list.get(i)+" ");
        }
    }
}
