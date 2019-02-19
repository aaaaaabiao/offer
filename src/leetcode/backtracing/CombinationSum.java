package leetcode.backtracing;


import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: abiao
 * @className: CombinationSum
 * @packageName: leetcode.backtracing
 * @description: https://leetcode.com/problems/combination-sum/
 * @data: 2019/2/19
 **/
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        backtracing(ret,ls,candidates,target, target,0);
        return ret;
    }

    public static void backtracing(List res,List<Integer> ls,int[] candidates,int target,int remain,int start){
        if (remain < 0) return;
        else if (remain == 0){
            List l = new ArrayList(ls);
            res.add(l);
        }else {
            for (int i = start; i < candidates.length;i++){
                ls.add(candidates[i]);
                backtracing(res,ls,candidates,target,remain-candidates[i],i);
                ls.remove(ls.size()-1);
            }
        }


    }

    public static void main(String[] args){
        int[] candidates = new int[]{2,3,7,6};
        List res = combinationSum(candidates,7);
        int a;
    }
}
