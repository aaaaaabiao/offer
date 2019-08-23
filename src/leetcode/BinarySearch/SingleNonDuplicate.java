package leetcode.BinarySearch;

/**
 * @version: V1.0
 * @author: abiao
 * @className: SingleNonDuplicate
 * @packageName: leetcode.BinarySearch
 * @description: 有序数组中的单一元素
 * @data: 2019/1/22
 **/
public class SingleNonDuplicate {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        if (h == 1) return nums[0];
        while (l < h){
            int mid = l+(h-l)/2;

            if (nums[mid] == nums[mid-1]){
                if ((mid - l + 1)%2 == 0){
                    l = mid + 1;
                }else {
                    h = mid-2;
                }
            }else if(nums[mid] == nums[mid+1]) {
                if ((h - mid + 1)%2 == 0){
                    h = mid - 1;
                }else {
                    l = mid + 2;
                }
            }else{
                return nums[mid];
            }
        }

        return nums[l];
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,1,2,2,3,3,4,4,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
