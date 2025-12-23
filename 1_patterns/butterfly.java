package patterns;

// *             * 
// * *         * * 
// * * *     * * * 
// * * * * * * * * 
// * * * * * * * * 
// * * *     * * *
// * *         * *
// *             * 

import java.util.Scanner;
public class butterfly {
        public static void main(String args[]){
        Scanner in = new Scanner (System.in);

        System.err.print("Enter the number :- ");
        int n= in.nextInt();
        //t1

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            for(int j=1; j<n-i+1; j++){
                System.out.print("  ");
            }
            for(int j=1; j<n-i+1; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        //t2

        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            for(int j=1; j<n-i+1; j++){
                System.out.print("  ");
            }
            for(int j=1; j<n-i+1; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
