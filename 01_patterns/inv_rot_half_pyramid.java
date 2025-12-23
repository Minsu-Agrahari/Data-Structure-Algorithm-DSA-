package patterns;

//    *
//   **
//  ***
// ****

import java.util.Scanner;
public class inv_rot_half_pyramid {
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);

        System.out.println("Enter the number:- ");
        int n = in.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=0; j<n-i; j++){
                System.out.print(" ");
            }
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }


    }
}
