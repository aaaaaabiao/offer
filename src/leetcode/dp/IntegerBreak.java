package leetcode.dp;
/**
 * @version: V1.0
 * @author: abiao
 * @className: IntegerBreak
 * @packageName: leetcode.dp
 * @description: 数组区间
 * @data: 2019/1/21
 **/
public class IntegerBreak {
    public static int integerBreak(int n) {
        if (n == 0 || n == 1) return 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = i-1; j >= 1; j--){
                dp[i] = Math.max(Math.max(dp[j]*(i-j),j*(i-j)),dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(integerBreak(10));
    }
}
