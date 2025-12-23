package basic_program;
import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int fact = 1, number =1;

        System.out.println("Enter the number for fatorial :- ");
        number = in.nextInt();
        for(int i=number; i>0 ; i--){
            fact *= i;
        }

        System.out.println("The factorial is :- "+fact);
    }
}
