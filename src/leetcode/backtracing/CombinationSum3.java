package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: abiao
 * @className: CombinationSum3
 * @packageName: leetcode.backtracing
 * @description: 组合3
 * @data: 2019/1/17
 **/
public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> finalRet = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        backtracing(ls,finalRet,1,n,k);
        return finalRet;
    }

    public static void backtracing(List<Integer> ls,List<List<Integer>> finalRet,int start,int n,int k){
        if (k == 0){
            int sum = 0;
            for (int val : ls){
                sum += val;
            }
            if (sum == n){
                finalRet.add(new ArrayList<>(ls));
            }
            return;
        }
        for (int i = start; i <= 9-k+1; i++){
            ls.add(i);
            backtracing(ls,finalRet,i+1,n,k-1);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args){

        List finalRet = combinationSum3(3,9);
        int a;
        int k = 5;
        while (k > 0){
            System.out.println(k);
            k--;
        }
    }
}
