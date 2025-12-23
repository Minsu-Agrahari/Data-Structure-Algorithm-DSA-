package patterns;


import java.util.Scanner;
public class number_pyranid {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        int n=5;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=(n-i); j++){
                System.out.print("_ ");
            }
            for(int j=1; j<=(2*i-1); j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
