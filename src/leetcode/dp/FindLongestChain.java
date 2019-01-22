package leetcode.dp;

import java.util.Arrays;
/**
 * @version: V1.0
 * @author: abiao
 * @className: FindLongestChain
 * @packageName: leetcode.dp
 * @description: 一组整数对能够构成的最长链
 * @data: 2019/1/22
 **/
public class FindLongestChain {
    public static int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        int res = 1;
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[len];
        for (int i = 0; i < len; i++){
            dp[i] =  1;
        }
        for (int i = 1; i < len; i++){
            for (int j = i-1; j >= 0; j--){
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    res = Math.max(res,dp[i]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[][] pairs = new int[][]{{1,2},{2,3},{3,4}};
        System.out.println(findLongestChain(pairs));
    }
}
