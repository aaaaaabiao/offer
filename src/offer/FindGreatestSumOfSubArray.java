package offer;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 连续子数组的最大和
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：动态规划
 描述：dp[i]:以i结尾的和最大的连续子数组。
    dp[i] = max(dp[i-1]+data[i],data[i]);
 其实只要保存前一个状态就行了。
 在这个过程中计算中max值
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class FindGreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int ret = 0;
        for (int i = 0; i < array.length; i++){
            int val = array[i];
            if (ret < 0){
                ret = val;
            }else {
                ret += val;
            }
            max = ret > max ? ret : max;
        }
        return max;
    }
}
