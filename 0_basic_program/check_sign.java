package basic_program;
import java.util.Scanner;

public class check_sign {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int n;

        System.out.println("Enter the number :- ");
        n = in.nextInt();

        if(n > 0)
            System.out.println("positive number");
        else
            System.out.println("negative number ");
    }
}
