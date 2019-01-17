package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;
/**
 * @version: V1.0
 * @author: abiao
 * @className: Permute
 * @packageName: leetcode.backtracing
 * @description: 排列
 * @data: 2019/1/17
 **/
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalRet = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        backtracing(ls,finalRet,visit,nums);
        return finalRet;
    }

    private static void backtracing(List<Integer> ls, List<List<Integer>> finalRet,
                             boolean[] visit,int[] nums){
        if (ls.size() == nums.length){
            finalRet.add(new ArrayList<>(ls));
            return;
        }

        for (int i = 0; i < visit.length; i++){
            if (visit[i]) continue;
            visit[i] = true;
            ls.add(nums[i]);
            backtracing(ls,finalRet,visit,nums);
            ls.remove(ls.size()-1);
            visit[i] = false;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        List finalRet = permute(nums);

        int a;
    }

}
