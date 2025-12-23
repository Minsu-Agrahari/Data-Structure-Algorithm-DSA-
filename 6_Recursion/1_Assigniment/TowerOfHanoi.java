public class TowerOfHanoi {
    static void TowerOfHanoi(int n, char from_rod, char aux_rod, char to_rod){
        if(n == 0) return;
        TowerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Moved disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        TowerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }    

    public static void main(String[] args){
        int n = 3;
        TowerOfHanoi(n, 'A', 'B', 'C');
    }
}
