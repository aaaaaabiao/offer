package leetcode.BinarySearch;
/**
 * @version: V1.0
 * @author: abiao
 * @className: SearchInsert
 * @packageName: leetcode.BinarySearch
 * @description: 在排序数组中寻找插入位置
 * @data: 2019/1/29
 **/
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) return 0;
        int l = 0;
        int h = nums.length - 1;
        while (l < h){
            int mid = l + (h-l)/2;
            if (target < nums[mid]){
                h = mid;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return target > nums[h] ? nums.length : l;
    }


    public static int searchInsert1(int[] nums, int target) {

        if (nums == null || nums.length == 0) return 0;
        int l = 0;
        int h = nums.length - 1;
        while (l <= h){
            int mid = l + (h-l)/2;
            if (target < nums[mid]){
                h = mid - 1;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return target > nums[nums.length-1] ? nums.length : l;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,5));
        System.out.println(searchInsert1(nums,0));
        System.out.println(searchInsert(nums,7));
    }
}
