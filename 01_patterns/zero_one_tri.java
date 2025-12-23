package patterns;

// 1
// 0 1
// 1 0 1
// 0 1 0 1
// 1 0 1 0 1

import java.util.Scanner;
public class zero_one_tri {
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);

        System.err.print("Enter the number :- ");
        int n= in.nextInt();
        char s0[] = {'0','1'};
        char s1[] = {'1','0'};
        for(int i=1; i<=n+1; i++){
            if(i%2 == 0){
                int c=0;
                for(int j=1; j<i; j++){
                    System.out.print(s1[c]+" ");
                    c++;
                    if(c>=2){
                        c=0;
                    }
                }
            }else{
                int c=0;
                for(int j=1; j<i; j++){
                    System.out.print(s0[c]+" ");
                    c++;
                    if(c>=2){
                        c=0;
                    }
                }
            }
            System.out.println();
        }
    }
}
