package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: abiao
 * @className: Subsets
 * @packageName: leetcode.backtracing
 * @description: 数组的所有子集
 * @data: 2019/2/13
 **/
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalRet = new ArrayList<>();
        backtracing(nums,new ArrayList<>(),finalRet,0);
        finalRet.add(new ArrayList<>());
        return finalRet;
    }



    public static void backtracing(int[] nums,List<Integer> ls,List<List<Integer>> finalRet,int start){
        for (int i = start; i < nums.length; i++){
            ls.add(nums[i]);
            finalRet.add(new ArrayList<>(ls));
            backtracing(nums,ls,finalRet,i+1);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        subsets(nums);
    }
}
