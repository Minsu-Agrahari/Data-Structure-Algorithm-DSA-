package array.two_array;

public class sprial_patt {
     
     
        public static void sprial_pattern(int mtx[][]){
            
            int start_row = 0;
            int start_col = 0;
            int end_row = mtx.length-1;
            int end_col = mtx[0].length-1;
    
            System.out.println(end_row);
            System.out.println(end_col);
            while((start_row <= end_row) && (start_col <= end_col)){
                
                if(end_row == 0){
                    for(int i=start_col; i<=end_col; i++){
                        System.out.print(mtx[start_row][i]+", ");
                    }
                    break;
                }else{
                    //top
                for(int i=start_col; i<=end_col; i++){
                    System.out.print(mtx[start_row][i] + " ");
                }
                start_row++;
                //right
                for(int i=start_row; i<=end_row; i++){
                    System.out.print(mtx[i][end_col] + " ");
                }
                end_col--;
                //bottom
                for(int i=end_col; i>=start_col;i--){
                    System.out.print(mtx[end_row][i]+" ");
                }
                end_row--;
                //left
                for(int i=end_row; i>=start_row; i--){
                    System.out.print(mtx[i][start_col]+" ");
                }
                start_col++;
            }
                }
        }
    
        public static void main(String args[]){
            int a[][] = {{99,2,3,4}};
            sprial_pattern(a);
        }
    
}

