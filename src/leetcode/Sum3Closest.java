

/*
*在数组中找出三数之和和target最接近的和
*思路：
* 1.先将nums排序
* 2.用三个指针分别指向第一个位置，第二个位置和最后一个位置
* 3.当三数之和小于target时，指针2后移；当三数之和大于target时，指针3前移
* 4.遍历整个nums，重复2，3.过程中记录最小的差值的和。
* */

import java.util.Arrays;

public class Sum3Closest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length-2; i++){
            int p = nums[i];
            int start = i+1;
            int end = nums.length-1;
            while (start < end){

                int sum = p + nums[start] + nums[end];
                if (sum < target){
                    start++;
                }else if (sum > target){
                    end--;
                }else {
                    return sum;
                }
                if (Math.abs(sum-target) < min){
                    res = sum;
                    min = Math.abs(sum-target);
                }

            }
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4},1));
        System.out.println(threeSumClosest(new int[]{0,1,2},3));
    }
}
