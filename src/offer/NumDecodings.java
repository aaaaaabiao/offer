package offer;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，
 ````````````````````````````````````例子`````````````````````````````````````
 例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode.com/problems/decode-ways/description/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：动态规划
 描述：dp[i]代表前i个字符有多少种翻译方法。
 dp[i] += dp[i-1]

 如果Integer.valueOf(str(i-1,i)) < 26
 dp[i] += dp[i-2]。

 实际上可以用保存前2个状态就行了
 p1:代表前i-1个字符所能翻译成的数
 p2:代表前i-2个字符所能翻译成的数
 每次迭代更新
 ````````````````````````````````````思考`````````````````````````````````````
 这道题要注意对0的处理：如果str[i] == '0',不应该加前p1的值。
 如果str[i-1] != '0'，才有可能p2的值。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/1
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class NumDecodings {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        char[] chs = s.toCharArray();
        int p1 = chs[0] == '0' ? 0 : 1; //代表前i-1个字符所能翻译成的数
        int p2 = 1;//代表前i-2个字符所能翻译成的数。
        for (int i = 1; i < len; i++){
            int p = 0;
            if(chs[i] != '0') p += p1;
            if (chs[i-1] != '0'){
                int num = Integer.valueOf(s.substring(i-1,i+1));
                if(num <= 26) p += p2;
            }
            p2 = p1;
            p1 = p;
        }
        return p1;
    }

    public static void main(String[] args){
        String str = "012";
        System.out.println(numDecodings(str));
    }
}
