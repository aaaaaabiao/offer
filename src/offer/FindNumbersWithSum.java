package offer;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：双指针
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 乘积最小：相差越大乘积越小。所以第一个符合条件的乘积肯定越小
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/6
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class FindNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {

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
