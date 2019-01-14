package leetcode.twopoint;
/**
 * @version: V1.0
 * @author: abiao
 * @className: ReverseVowels
 * @packageName: leetcode.twopoint
 * @description: 反转字符串中的元音字符
 * @data: 2019/1/14
 **/
public class ReverseVowels {
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        if (s == null || s.length() == 0) return "";
        int i = 0;
        int j = arr.length-1;
        while (i <= j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if (judgeVowel(ch1) && judgeVowel(ch2)){
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }else if (judgeVowel(ch1)){
                j--;
            }else if (judgeVowel(ch2)){
                i++;
            }else {
                i++;
                j--;
            }
        }

        return new String(arr);
    }

    public static  boolean judgeVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args){
        System.out.println(reverseVowels("leetcode"));
    }
}
