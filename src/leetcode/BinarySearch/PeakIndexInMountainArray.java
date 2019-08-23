package leetcode.BinarySearch;
/**
 * @version: V1.0
 * @author: abiao
 * @className: PeakIndexInMountainArray
 * @packageName: leetcode.BinarySearch
 * @description: 找到数组顶部的位置
 * @data: 2019/2/12
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 **/
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0;
        int h = A.length - 1;

        while (l < h){
            int mid = l + (h-l)/2;
            if (A[mid -1] < A[mid] && A[mid] > A[mid+1]){
                return mid;
            }

            if (A[mid - 1] < A[mid]){
                l = mid + 1;
            }else {
                h = mid - 1;
            }
        }

        return l;
    }
}
