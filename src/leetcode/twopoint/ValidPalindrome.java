package leetcode.twopoint;
/**
 * @version: V1.0
 * @author: abiao
 * @className: ValidPalindrome
 * @packageName: leetcode.twopoint
 * @description: 可以删除一个字符，判断是否能构成回文字符串
 * @link https://leetcode.com/problems/valid-palindrome-ii/description/
 * @data: 2019/1/14
 **/
public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        int i = 0;
        int j = s.length() - 1;

        while (i <= j){
            if (s.charAt(i) != s.charAt(j)){
                return judgePalindrome(s,i+1,j) || judgePalindrome(s,i,j-1) ;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean judgePalindrome(String str,int start,int end){

        while (start <= end){
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(validPalindrome("abca"));
    }
}
