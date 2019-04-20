package leetcode.BinarySearch;

/**
 * Created by 73681 on 2019/3/4.
 */
public class Solution {
    //第一个不小于target的元素（第一个大于或等于target的数）
    public static int closestLessthanTarget(int[] arr,int target){
        int l = 0;
        int h = arr.length;
        while (l < h){
            int mid = l + (h - l) / 2;
            if (target <= arr[mid]){
                h = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }


    //大于给定元素的最小元素（第一个大于target的元素）
    public static int closestGreatestTarget(int[] arr,int target){
        int l = 0;
        int h = arr.length;
        while (l < h){
            int mid = l + (h - l) / 2;
            if (target < arr[mid]){
                h = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }



    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 3, 3, 3, 5,6};
//        System.out.println(closestLessthanTarget(arr,3));
//        System.out.println(closestLessthanTarget(arr,4));
//        System.out.println(closestGreatestTarget(arr,3));
        System.out.println(closestGreatestTarget(arr,10));
    }
}
