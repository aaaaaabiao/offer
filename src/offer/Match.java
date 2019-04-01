package offer;
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
 方法：
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
        return matchCore(str, strIndex, pattern, patternIndex);

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
                matchCore(str,si,pattern,pi+2);
            }
        }

        if(si < slen && (str[si] == pattern[pi] || pattern[pi] == '.')){
            return matchCore(str,si + 1,pattern,pi+1);
        }else{
            return false;
        }

    }
    public static void main(String[] args){
        System.out.println(match(new char[]{},new char[]{'.','*'}));
    }
}
