package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: abiao
 * @className: Combinations
 * @packageName: leetcode.backtracing
 * @description: 组合
 * @data: 2019/1/17
 **/
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finalRet = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        backtracing(ls,finalRet,1,n,k);
        return finalRet;
    }

    public static void backtracing(List<Integer> ls,List<List<Integer>> finalRet,int start,int n,int k){
        if (k == 0){
            finalRet.add(new ArrayList<>(ls));
            return;
        }
        for (int i = start; i <= n-k+1; i++){
            ls.add(i);
            backtracing(ls,finalRet,i+1,n,k-1);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args){

        List finalRet = combine(4,2);
        int a;
    }
}
