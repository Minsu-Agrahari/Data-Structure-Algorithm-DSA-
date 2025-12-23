package patterns;

//         * * * * * 
//       *       *
//     *       *
//   *       *
// *       *
// * * * * *

import java.util.Scanner;
public class solid_rhombus {
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);

        int n=5;
        int c=1;
        while(c!=0){
            //s1.1
            for(int i=1; i<n; i++){
                System.out.print("  ");
            }

            //s1.2
            for(int i=0; i<n; i++){
                System.out.print("* ");
            }
            c--;
            System.out.println();
        }

        //s3 s4
        for(int i=1; i<n; i++){
            for(int j=0; j<(n-1-i); j++){
                System.out.print("  ");
            }
            for(int j=1; j<=n; j++){
                if(j==1){
                    System.out.print("* ");
                }else if(j == n){
                    System.out.print("* \n");
                }else
                    System.out.print("* ");
            }
        }

        //s4
        for(int i=0; i<n; i++){
            System.out.print("* ");
        }
    }
}
