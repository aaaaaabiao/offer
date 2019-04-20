package leetcode.dp;

public class Package {

    public static int maxValue(int v[], int w[], int m){
        int[] dp = new int[m+1];//用能装i重量的背包所能装的最大价值。
        dp[0] = 0;
        for (int i = 1; i <= m; i++){
            dp[i] = 0;
            for (int j = 0; j < v.length; j++){
                if (w[i] <= i){
                    dp[i] = Math.max(dp[i],dp[i-w[i]]+v[i]);
                }
            }
        }
        return dp[m];
    }


    public static void main(String[] args){

    }
}
