/*
 * You are given n pairs of numbers. In every pair, the first 
 * number is always smaller than the second number. A pair (c,d) can come after
 * pair (a,b) if b<c. Find the longest chain which can be formed 
 * from a given set of pairs.
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
 
public class MaxLenChainOfPairs{

    public static void print(int[][] arr, int size){
        for(int i=0; i<size; i++){
            for(int j=0; j<2; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // input data :-
        int[][] pairs ={ 
            {5, 24},
            {39, 60},
            {5, 28},
            {27, 40}, 
            {50, 90}
        };

        // sort by the ending time
        // using lambda function
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));

        print(pairs, pairs.length);

        ArrayList<ArrayList<Integer>> PairList = new ArrayList<>();
        
        // selecting the 1st pair
        PairList.add(new ArrayList<>(Arrays.asList(pairs[0][0], pairs[0][1])));
        int counter = 1; 
        int lastEnd = pairs[0][1];

        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0] > lastEnd){
                PairList.add(new ArrayList<>(Arrays.asList(pairs[i][0], pairs[i][1])));
                lastEnd = pairs[i][1];
                counter++;
            }
        }

        System.out.println("Count of the pair :- "+ counter);
        System.out.println(PairList);
    }
}