package leetcode.BinarySearch;
import java.util.ArrayList;
/**
 * @version: V1.0
 * @author: abiao
 * @className: FindClosestElements
 * @packageName: leetcode.BinarySearch
 * @description: 排序数组中最接近x的k个元素
 * @data: 2019/2/13
 **/
import java.util.List;
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int h = arr.length - k;

        while (l < h){
            int mid = l + (h-l)/2;
            if (x - arr[mid] > arr[mid+k] - x){
                l = mid + 1;
            }else {
                h = mid;
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = l; i <= l+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
