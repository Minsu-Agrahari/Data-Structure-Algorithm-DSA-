package basic_program;
import java.util.Scanner;

public class leap_year {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int year;
        System.out.println("Enter the year to be checked :- ");
        year = in.nextInt();

        if((year % 4 == 0) || (year % 100 == 0 && year % 400 == 0))
            if(year % 100 == 0)
            System.out.println("leap year");

        else
            System.out.println("not a leap year");
    }
}
