package leetcode.BinarySearch;
/**
 * @version: V1.0
 * @author: abiao
 * @className: MySqrt
 * @packageName: leetcode.BinarySearch
 * @description: https://leetcode.com/problems/sqrtx/
 * @data: 2019/2/15
 **/
public class MySqrt {
    public static int mySqrt(int x) {
        int l = 1;
        int h = x;

        while (l <= h){
            int mid = l + (h-l)/2;
            if (x / mid == mid){
                return mid;
            }else if (x / mid < mid){
                h = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return h;
    }

    public static void main(String[] args){
        System.out.println(mySqrt(8));
    }
}
