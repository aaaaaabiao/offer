package leetcode.BinarySearch;

/**
 * @version: V1.0
 * @author: abiao
 * @className: IsSubsequence
 * @packageName: leetcode.BinarySearch
 * @description: 判断一个串是不是另一个串的子串
 * @data: 2019/1/31
 **/
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int p = 0;
        int q = 0;

        if (s.length() == 0){
            return true;
        }
        while (p < t.length() && q < s.length()){
            char chs = s.charAt(q);
            char cht = t.charAt(p);
            if (chs == cht){
                q++;
            }
            p++;
            if (q == s.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}
