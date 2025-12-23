package patterns;

// 12345
// 1234
// 123
// 12
// 1

import java.util.Scanner;
public class inv_half_num_pyramid {
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);

        System.out.print("Enter the number :- ");
        int n= in.nextInt();

        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
