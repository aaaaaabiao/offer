package offer;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @version: V1.0
 * @author: abiao
 * @className: FindNumbersWithSum
 * @packageName: offer
 * @description: 在排序数组中找到两数之和等于sum，如果有多个，要求找到乘积最小的两数。
 * @data: 2018/12/28
 **/
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum1(int [] array, int sum) {

        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>(2);
        int res = Integer.MAX_VALUE;
        for (int val : array){
            int need = sum - val;
            if (set.contains(need)){
                int product = need * val;
                if (product < res){
                    res = product;
                    arrayList.set(0,need < val ? need : val);
                    arrayList.set(1,need < val ? val : need);
                }

            }
            set.add(val);
        }
        return arrayList;
    }

    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {

        if (array.length < 2 || array == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n1 = 0;
        int n2 = 0;
        int start = 0;
        int end = array.length - 1;
        int res = Integer.MAX_VALUE;
        boolean flag = false;
        while (start < end){
            int n = array[start] + array[end];
            if (n == sum){
                int product = array[start] * array[end];
                if (product < res){
                    res = product;
                    n1 = array[start];
                    n2 = array[end];
                    flag = true;
                }
                start++;
                end--;
            }else if (n < sum){
                start++;
            }else {
                end--;
            }
        }

        if (flag){
            arrayList.add(n1);
            arrayList.add(n2);
        }
        return arrayList;
    }



    public static ArrayList<Integer> findNumbersWithSum2(int [] array, int sum) {

        if (array.length < 2 || array == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = 0;
        int end = array.length - 1;
        while (start < end){
            int n = array[start] + array[end];
            if (n == sum){
                arrayList.add(array[start]);
                arrayList.add(array[end]);
                break;
            }else if (n < sum){
                start++;
            }else {
                end--;
            }
        }

        return arrayList;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,8,9,10};
        List ret = findNumbersWithSum(arr,9);
        int a;
    }
}
