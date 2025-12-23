package basic_program;
import java.util.Scanner;

public class sum_even_odd {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int choice=0 , even_sum =0, odd_sum=0, number=0;

        do{
            System.out.println("Enter the number :- ");
            number = in.nextInt();

            if(number % 2 ==0 ){
                even_sum+=number;
            }else
                odd_sum+=number;

            System.out.println("!! Do you want to continue than press 1 !!");
            choice = in.nextInt();
        }while(choice == 1);

        System.out.println("Even sum = "+ even_sum);
        System.out.println("odd sum = "+ odd_sum);

    }
}
