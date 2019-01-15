package leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @version: V1.0
 * @author: abiao
 * @className: TopKFrequent
 * @packageName: leetcode.sort
 * @description: 出现频率最多的K个数字
 * @data: 2019/1/15
 **/
public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }

        //这是一个桶，桶中的每一项是一个list对象。出现相同频率的数字放在一个元素里面
        List<Integer>[] ls = new List[nums.length+1];

        for (int key : map.keySet()){
            int val = map.get(key);

            if (ls[val] == null){
                ls[val] = new ArrayList<>();
            }
            ls[val].add(key);
        }

        List<Integer> ret = new ArrayList<>();

        for (int i = ls.length-1; i >= 0 && ret.size() < k; i--){
            if (ls[i] != null){
                ret.addAll(ls[i]);
            }
        }

        return ret;
    }

    public static void main(String[] args){
        int[] nums = new int []{1,1,1,2,2,3};
        List ret = topKFrequent(nums,2);
        int a = 0;
    }
}
