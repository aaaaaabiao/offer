package leetcode.Array;

public class GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        int s = 0;
        int e = n-1;
        int c = 1;
        int[][] ret = new int[n][n];
        while(s <= e){
            for(int i = s; i <= e; i++){
                ret[s][i] = c++;
            }

            for(int i = s+1; i <= e; i++){
                ret[i][e] = c++;
            }


            for(int i = e-1; i >= s; i--){
                ret[e][i] = c++;
            }

            for(int i = e-1; i > s; i--){
                ret[i][s] = c++;
            }


            s += 1;
            e -= 1;
        }

        return ret;
    }

    public static void main(String[] args){
        generateMatrix(4);
    }
}
