package leetcode.BinarySearch;
/**
 * @version: V1.0
 * @author: abiao
 * @className: MinSubArrayLen
 * @packageName: leetcode.BinarySearch
 * @description: 大于target的最短子数组长度
 * @data: 2019/1/31
 **/
public class MinSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        while (start < len && end < len){
            while (sum < s && end < len){
                sum += nums[end++];
            }

            while (sum >= s && start < len){
                min = Math.min(min,end-start);
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
}
