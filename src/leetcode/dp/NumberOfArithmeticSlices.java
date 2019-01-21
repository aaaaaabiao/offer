package leetcode.dp;
/**
 * @version: V1.0
 * @author: abiao
 * @className: NumberOfArithmeticSlices
 * @packageName: leetcode.dp
 * @description: 数组中等差递增子区间
 * @data: 2019/1/21
 **/
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) return 0;
        int len = A.length;
        int[] dp = new int[len];

        for (int i = 2; i < len; i++){
            if (A[i] - A[i-1] == A[i-1]-A[i-2]){
                dp[i] = dp[i-1]+1;
            }
        }
        int res = 0;
        for (int val : dp){
            res += val;
        }
        return res;
    }
}
