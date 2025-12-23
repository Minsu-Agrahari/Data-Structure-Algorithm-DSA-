public class num2string {
    
    static String digits[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static void word(int num){
        if(num == 0) return;

        int lastdigit = num % 10;

        word(num/10);
        System.out.print(digits[lastdigit] + " ");
    }
    public static void main(String[] args){
        int number = 20190;
        word(number);
    }
}
