
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 ````````````````````````````````````例子`````````````````````````````````````
 输入: s = "leetcode", wordDict = ["leet", "code"]
 输出: true
 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。


 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 输出: true
 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 注意你可以重复使用字典中的单词。

 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 输出: false
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/word-break/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：动态规划
 描述：dp[i]代表s中前i个子串是否能被字典拆分
 if dp[j] && wordDict.contains(s.substring(j,i)) 0 <= j < i
    dp[i] = true;
 ````````````````````````````````````思考`````````````````````````````````````

 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/10
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/

package leetcode.dp;

import java.util.List;



public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for(int i = 1; i <= len; i++){
            for(int j = i-1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }
}

