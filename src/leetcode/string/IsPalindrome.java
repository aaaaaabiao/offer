package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        int len = s.length();
        int i = 0;
        int j = len - 1;
        char[] arr = s.toCharArray();
        while(i < j){
            while(i < len && !isValid(arr[i])) i++;
            while(j >= 0 && !isValid(arr[j])) j--;
            if(i < j && arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }


    public boolean isValid(char ch){
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z');
    }

    public static void main(String[] args){
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(""));
    }
}
