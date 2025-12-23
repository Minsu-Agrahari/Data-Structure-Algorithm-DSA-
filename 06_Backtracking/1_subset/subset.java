/***Time complexity :- O(2^n * n) 
 * Space Complexity :- O(n)
*/

public class subset{
    public static void subset (String str, String ans, int currIdx){
        // base case
        if(currIdx == str.length()){
            System.out.println(ans);
            return;
        }

        // small problem
        subset(str, ans+str.charAt(currIdx), currIdx+1);
        subset(str, ans, currIdx+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        subset(str, "", 0);
    }
}