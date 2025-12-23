package bit_manipulation;
public class even_odd {
    public static void main(String args[]){
        int nums = 2;

        if((nums & 1) == 0){
            System.out.println("even");
        }else   
            System.out.println("odd");
    }
}
