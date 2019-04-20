package leetcode.Array;


import java.util.HashMap;

/*
* 题目描述：给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
*   输入: [100, 4, 200, 1, 3, 2]
    输出: 4
    解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
* */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();//key代表当前元素所在子序列的长度。
        int max = Integer.MIN_VALUE;
        for(int val : nums){
            if(!map.containsKey(val)){
                map.put(val,1);
                if(map.containsKey(val-1)){
                    int first = (val-1) - map.get(val-1) + 1;//连续子序列的第一个值
                    int v = map.get(first)+1;
                    max = Math.max(max,v);
                    map.put(val,v);
                    map.put(first,v);
                }

                if(map.containsKey(val+1)){
                    int first = (val) - map.get(val) + 1;//连续子序列的第一个值
                    int end = (val+1) + map.get(val+1) - 1;//连续子序列的最后一个值
                    int v = map.get(first)+map.get(end);
                    max = Math.max(max,v);
                    map.put(end,v);
                    map.put(first,v);
                }
            }
        }
        return max;
    }


    public static void main(String[] args){
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
