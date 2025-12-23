package patterns;
// ******
// *    *
// *    *
// *    *
// ******

import java.util.Scanner;

public class hollow_rectangle {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = 6;
        // System.out.print("Entet the number :- ");
        // n = in.nextInt();

        for(int i = 0; i<n ; i++){
            System.out.print("*");
        }
        System.out.print("\n");

        for(int i=1; i<(n-2); i++){
            for(int j=0; j<n; j++){
                if(j==0){
                    System.out.print("*");
                }else if (j==(n-1)){
                    System.out.println("*");
                }else
                    System.out.print(" ");
            }
        }

        for(int i=0; i<n; i++){
            System.out.print("*");
        }
    }
}
