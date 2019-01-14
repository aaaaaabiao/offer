package leetcode.dp;


/**
 * @version: V1.0
 * @author: abiao
 * @className: LongestPalindromeSubseq
 * @packageName: leetcode.dp
 * @description: 最长回文子串,最长回文子序列
 * @data: 2019/1/14
 **/
public class LongestPalindromeSubseq {
    /*
    * 最长回文子序列
    * */
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] p = new int[len][len];
        for (int i = 0; i < len; i++) {
            p[i][i] = 1;
            if (i + 1 < len) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    p[i+1][i] = 2;
                } else {
                    p[i+1][i] = 0;
                }
            }
        }
        for (int i = 0; i < len; i++){
            for (int j = i-1; j >= 0; j--){
                if (s.charAt(i) == s.charAt(j)){
                    p[i][j] = p[i-1][j+1]+2;
                }else {
                    p[i][j] = Math.max(p[i-1][j],p[i][j+1]);
                }
            }
        }
        return p[len-1][0];
    }

    /*
    * 最长回文子串
    * */
    public static int longestPalindromeSubstr(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] p = new int[len][len];
        int ret = 1;
        for (int i = 0; i < len; i++) {
            p[i][i] = 1;
            if (i + 1 < len) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    p[i+1][i] = 2;
                    if (p[i+1][i] > ret){
                        ret = p[i+1][i];
                    }
                } else {
                    p[i+1][i] = 0;
                }
            }
        }

        for (int i = 0; i < len; i++){
            for (int j = i-2; j >= 0; j--){
                if (s.charAt(i) == s.charAt(j) && p[i-1][j+1] > 0){
                    p[i][j] = p[i-1][j+1]+2;
                    ret = Math.max(p[i][j],ret);
                }else {
                    p[i][j] = 0;
                }
            }

        }
        return ret;
    }

    /*
     * 最长回文子串
     * */
    public static String longestPalindromeSubstrRetStr(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        int[][] p = new int[len][len];
        int ret = 1;
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < len; i++) {
            p[i][i] = 1;
            if (i + 1 < len) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    p[i+1][i] = 2;
                    if (p[i+1][i] > ret){
                        ret = p[i+1][i];
                        p1 = i;
                        p2 = i+1;
                    }
                } else {
                    p[i+1][i] = 0;
                }
            }
        }

        for (int i = 0; i < len; i++){
            for (int j = i-2; j >= 0; j--){
                if (s.charAt(i) == s.charAt(j) && p[i-1][j+1] > 0){
                    p[i][j] = p[i-1][j+1]+2;
                    if (p[i][j] > ret){
                        ret = p[i][j];
                        p1 = j;
                        p2 = i;
                    }
                }else {
                    p[i][j] = 0;
                }
            }

        }
        return s.substring(p1,p2+1);
    }


    public static void print(int[][] a){
        System.out.println();
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[0].length; j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        System.out.println(longestPalindromeSubseq("aaabaaaaaaaa"));
        System.out.println(longestPalindromeSubstr("aaabaaaaaaaa"));
        System.out.println(longestPalindromeSubstrRetStr("aaabaaaaaaaa"));
        System.out.println(longestPalindromeSubstr("aaaa"));
        System.out.println(longestPalindromeSubstrRetStr("aaaa"));

    }

}
