/*
 * We are given an infinite 
 * supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].
 * Find min no. of conis/notes to make change for a value "V".
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        
        // input :- 
        int amount = 590;
        Integer[] denominator = {2000, 100, 500, 50, 20, 10, 5, 2, 1};
        Arrays.sort(denominator, Comparator.reverseOrder());
        
        // System.out.println(Arrays.toString(denominator));
        
        ArrayList <Integer> ans = new ArrayList<>();
        
        for(int i=0; i<denominator.length; i++){
            if(denominator[i] <= amount){
                while(denominator[i] <= amount){
                    ans.add(denominator[i]);
                    amount-=denominator[i];
                }
            }
        }

        System.out.println("Minimum number of coins :- "+ans.size());
        System.out.println("Coins/notes used :- "+ans);
    }    
}



"((((((((("