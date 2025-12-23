public class string_len{
    public static int len(String str, int i, int size){
        char ch = str.charAt(i);
        if(ch == ' ') return size;
        return len(str, i+1, size+1);
    }

    public static void main(String[] args){
        String str = "Minsu";
        str = str + " ";
        int result = len(str, 0, -1);
        System.out.print(result);
    }
}
