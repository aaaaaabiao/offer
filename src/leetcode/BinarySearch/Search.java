package leetcode.BinarySearch;


/**
 * 搜索
 *
 * @author hubiao
 * @date 2019/7/18
 */
public class Search {
    public static int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while(l < h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > nums[h]){
                if(nums[l] <= target && target < nums[mid]){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(nums[mid] < target && target <= nums[h]){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){

    }
}
