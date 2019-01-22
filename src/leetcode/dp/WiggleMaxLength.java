package leetcode.dp;
/**
 * @version: V1.0
 * @author: abiao
 * @className: WiggleMaxLength
 * @packageName: leetcode.dp
 * @description: 最长摆动子序列
 * @data: 2019/1/22
 **/
public class WiggleMaxLength {
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int up = 1;//第i-1是升的，最长摆动子序列的长度。
        int down = 1;//第i-1是降的，最长摆动子序列的长度。

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]){
                up = down+1;
            }else if (nums[i] < nums[i-1]){
                down = up+1;
            }
        }
        return Math.max(up,down);
    }

    public static void main(String[] args){
        System.out.println(wiggleMaxLength(new int[]{0,0}));
    }
}
