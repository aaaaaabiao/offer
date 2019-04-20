package leetcode.dp;
/**
 * @version: V1.0
 * @author: abiao
 * @className: CanJump
 * @packageName: leetcode.dp
 * @description: https://leetcode.com/problems/jump-game/
 * @data: 2019/2/15
 **/
public class CanJump {
    //动态规划解法
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++){
            for (int j = i-1; j >= 0; j--){
                if (dp[j] && i-j <= nums[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }

    //贪心解法
    public static boolean canJump1(int[] nums) {
        int reach = 0;//代表所能到达的最远位置
        int len = nums.length;
        for (int i = 0; i < nums.length; i++){
            //当前位置i不能到达就肯定达到不了最后的位置了
            if (i > reach || reach >= len - 1) break;
            reach = Math.max(reach,i+nums[i]);
        }

        return reach >= len-1;
    }


    public static boolean canJump2(int[] nums) {
        int len = nums.length;
        int canReach = len - 1;//代表所能到达的最远位置
        for (int i = len-1; i >= 0; i--){
            if(nums[i] + i >= canReach) canReach = i;
        }
        return canReach == 0;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,3,1,1,4};
        int[] nums1 = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums1));
        System.out.println(canJump1(nums));
        System.out.println(canJump1(nums1));
        System.out.println(canJump2(nums1));
        System.out.println(canJump2(nums));
    }
}
