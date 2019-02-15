package leetcode.dp;
/**
 * @version: V1.0
 * @author: abiao
 * @className: UniquePaths
 * @packageName: leetcode.dp
 * @description: https://leetcode.com/problems/unique-paths/
 * @data: 2019/2/15
 **/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //n行m列
        int[][] dp = new int[n][m];

        //初始化第一行
        for (int i = 0; i < m; i++){
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++){
            dp[i][0] = 1;
        }

        if (m > 1 && n > 1){
            for (int i = 1; i < n; i++){
                for (int j = 1; j < m; j++){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
