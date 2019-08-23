package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @version: V1.0
 * @author: abiao
 * @className: ThreeSum
 * @packageName: leetcode.Array
 * @description: 三数之和
 * @data: 2019/2/18
 **/
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++){
            //边界条件判断
            if (i > 0 && nums[i-1] == nums[i]) continue;

            int p = i+1;
            int q = nums.length-1;
            int target = 0 - nums[i];
            while (p < q){
                if (p > i+1 && nums[p] == nums[p-1]){
                    p++;
                    continue;
                }
                if (q < nums.length-1 && nums[q] == nums[q+1]){
                    q--;
                    continue;
                }
                if (nums[p] + nums[q] == target){
                    List ls = Arrays.asList(nums[i],nums[p],nums[q]);
                    res.add(ls);
                    p++;
                    q--;
                }else if (nums[p] + nums[q] > target){
                    q--;
                }else {
                    p++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,-1,-1,0};
        List res = threeSum(nums);
        int a = 0;
    }
}
