package offer;

import java.util.ArrayList;
import java.util.List;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 在本题中，匹配是指字符串的所有字符匹配整个模式。
 ````````````````````````````````````例子`````````````````````````````````````
 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：递归
 描述：用si和pi分别代表字符串str和模式pattern当前的位置
 1.如果当pattern[pi+1] = '*'
    1.str[si] == pattern[pi] || pattern[pi] == '.'。说明第一个字符匹配，这时候有三种情况
        1.视x*匹配0个字符，即*前一个字符出现0次。pi = pi+2
        2.匹配1个字符，即*前一个字符仅出现1次。si = si+1,pi = pi+2
        3.匹配1个字符，模式保持不变。si = si + 1。pi不动。
        最后结果为1 || 2 || 3
    2.如果第一个字符不匹配
        模式后移两位，pi = pi+2。也就是视x*匹配0个字符。
 2.如果当str[si] == pattern[pi] || pattern[pi] == '.',这个代表字符串这个字符可以被模式匹配('.'可以代表任意字符)。s1++,pi++,接着往下匹配。
 3.否则返回false



 方法:动态规划
 描述：dp[i][j]:代表字符串前i个字符与模式前j个字符是否匹配。
 转移方程为:
e 4oi 2.p[j] == '*'
    如果s[i] == p[j-1] || p[j-1] == '.'
        dp[i][j] = dp[i-1][j] 代表*匹配一个或多个字符。
                    || dp[i][j-1]代表*匹配一字符
                    || dp[i][j-2]代表*匹配空字符
    否则
        dp[i][j] = dp[i][j-2]

 ````````````````````````````````````思考`````````````````````````````````````
    1.必须要先检查后一个字符是不是*。
    2.做边界判断。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/1
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class Match {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCoredp(str, strIndex, pattern, patternIndex);

    }
    private static boolean matchCore(char[] str,int si, char[] pattern,int pi) {
        int slen = str.length;
        int plen = pattern.length;
        if(si == slen && pi == plen) return true;
        if(si != slen && pi == plen) return false;
        if(pi+1 < plen && pattern[pi+1] == '*'){
            if(si < slen &&(str[si] == pattern[pi] || pattern[pi] == '.')){
                return matchCore(str,si,pattern,pi+2) || matchCore(str,si+1,pattern,pi+2)
                        || matchCore(str,si+1,pattern,pi);
            }else{
                return matchCore(str,si,pattern,pi+2);
            }
        }

        if(si < slen && (str[si] == pattern[pi] || pattern[pi] == '.')){
            return matchCore(str,si + 1,pattern,pi+1);
        }else{
            return false;
        }

    }



    private static boolean matchCoredp(char[] str,int si, char[] pattern,int pi) {
        int slen = str.length;
        int plen = pattern.length;
        boolean [][] dp = new boolean[slen+1][plen+1];

        dp[0][0] = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }


        for (int i = 0; i < slen; i++){
            for (int j = 0; j < plen; j++){
                if(j > 0 && pattern[j] == '*'){
                    if(str[i] == pattern[j-1] || pattern[j-1] == '.'){
                        dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
                    }else{
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                }

                if(str[i] == pattern[j] || pattern[j] == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }
            }
        }
        return dp[slen][plen];
    }
    public static void main(String[] args){
//        System.out.println(match("aab".toCharArray(),"c*a*b".toCharArray()));
        System.out.println(match("aab".toCharArray(),"c*a*b".toCharArray()));
        ArrayList<String> ls = new ArrayList<>();
    }
}
