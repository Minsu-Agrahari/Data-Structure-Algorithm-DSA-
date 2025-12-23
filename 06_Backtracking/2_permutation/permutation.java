// import java.lang.Thread.State;
import java.util.*;

public class permutation{

    public static void arragement(String str, String ans){
        // Base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // Smaller Problem
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);
            arragement(newString, ans+ch);
        }
    }
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter your String to Find the possible arragement !! ");
        String str = in.nextLine();
        
        arragement(str, " ");
    }
}