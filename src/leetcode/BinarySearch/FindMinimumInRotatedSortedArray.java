package leetcode.BinarySearch;

/**
 * @version: V1.0
 * @author: abiao
 * @className: FindMinimumInRotatedSortedArray
 * @packageName: leetcode.BinarySearch
 * @description: 找到旋转数组中的最小值
 * @data: 2019/1/29
 **/
public class FindMinimumInRotatedSortedArray {


    //数组没有重复元素
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0;
        int h = nums.length - 1;

        while (l < h){
            int mid = l + (h-l)/2;
            if (nums[mid] < nums[h]){
                h = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[l];
    }


    //数组有重复元素
    public static int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0;
        int h = nums.length - 1;

        while (l < h){
            int mid = l + (h-l)/2;
            if (nums[mid] < nums[h]){
                h = mid;
            }else if (nums[mid] > nums[h]){
                l = mid + 1;
            }else {
                if (nums[h] == nums[l]){
                    h--;
                    l++;
                }else {
                    h = mid;
                }

            }
        }
        return nums[l];
    }

    public static void main(String[] args){
//        int[] nums = new int[]{3,4,5,1,2};
        int[] nums1 = new int[]{3,1,2};
        System.out.println(findMin(nums1));

        int[] nums2 = new int[]{3,3,1,3};
        System.out.println(findMin2(nums2));
    }
}
