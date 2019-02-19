package leetcode.backtracing;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @version: V1.0
 * @author: abiao
 * @className: CombinationSum2
 * @packageName: leetcode.backtracing
 * @description: https://leetcode.com/problems/combination-sum-ii/
 * @data: 2019/2/19
 **/
public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(candidates);
        backtracing(res,ls,candidates,target,target, 0);
        return res;
    }

    public static void backtracing(List res, List<Integer> ls,int[] candidates,int target,int remain,int start){
        if (remain < 0) return;
        else if (remain == 0){
            res.add(new ArrayList<>(ls));
        }else {
            for (int i = start; i < candidates.length;i++){
                if (i > start && candidates[i] == candidates[i-1])continue;//代表第i个已经用过了
                ls.add(candidates[i]);
                backtracing(res,ls,candidates,target,remain-candidates[i],i+1);
                ls.remove(ls.size()-1);
            }
        }
    }

    public static void main(String[] args){
        int[] candidates = new int[]{1,2,2,2,5};
        List ret = combinationSum2(candidates,5);
        int a;
    }
}
