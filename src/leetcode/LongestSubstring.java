package leetcode;

/**
 * 最长不重复子串
 *
 * @author hubiao
 */
import java.util.HashMap;

//求一个字符串中最长不重复子串的长度，时间复杂度O(n)
public class LongestSubstring{
    public static int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        for(int i = 0,j = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                //注意这种情况abcba
                j = Math.max(j,map.get(ch)+1);
            }
            map.put(ch, i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        // System.out.println(longestPalindrome("abcabcbb"));
        // System.out.println(longestPalindrome("bbbbb"));
        // System.out.println(longestPalindrome("pwwkew"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("abcba"));

    }
}