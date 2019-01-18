package leetcode.dp;
/**
 * @version: V1.0
 * @author: abiao
 * @className: LengthOfLIS
 * @packageName: leetcode.dp
 * @description: 最长递增子序列
 * @data: 2019/1/18
 **/
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }
        for (int i = 0; i < nums.length; i++){
            for (int j = i-1; j >= 0; j--){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
