package leetcode.BinarySearch;

/**
 * @version: V1.0
 * @author: abiao
 * @className: SearchInRotatedSortedArray
 * @packageName: leetcode.BinarySearch
 * @description: 在旋转数组中找到目标值
 * @data: 2019/1/29
 **/
public class SearchInRotatedSortedArray {

    //数组无重复元素
    public static int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h){
            int mid = l + (h - l)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < nums[h]){
                if (target > nums[mid] && target <= nums[h]){
                    l = mid + 1;
                }else {
                    h = mid - 1;
                }
            }else {
                if (target < nums[mid] && target >= nums[l]){
                    h = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }


    //数组有重复元素
    public static boolean search1(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h){
            int mid = l + (h - l)/2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[mid] < nums[h]){
                if (target > nums[mid] && target <= nums[h]){
                    l = mid + 1;
                }else {
                    h = mid - 1;
                }
            }else if(nums[mid] > nums[h]){
                if (target < nums[mid] && target >= nums[l]){
                    h = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (nums[h] == nums[l]){
                    h--;
                    l++;
                }else {
                    h = mid - 1;
                }
            }
        }

        return false;
    }


    public static void main(String[] args){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums,3));

        int[] nums1 = new int[]{2,5,6,0,0,1,2};
        System.out.println(search1(nums,0));
    }
}
