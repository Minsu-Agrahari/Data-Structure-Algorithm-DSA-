// Time complexity: O(n)
// space complexity: O(1)
// This code finds the maximum element in an ArrayList of integers.

import java.util.ArrayList;
public class MaxElem {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        System.out.println("Max Element :- "+ max);
    }    
}
