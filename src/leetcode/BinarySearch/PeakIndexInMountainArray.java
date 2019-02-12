package leetcode.BinarySearch;
/**
 * @version: V1.0
 * @author: abiao
 * @className: PeakIndexInMountainArray
 * @packageName: leetcode.BinarySearch
 * @description: 找到数组顶部的位置
 * @data: 2019/2/12
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
