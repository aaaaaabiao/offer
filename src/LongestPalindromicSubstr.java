
/*最长回文子串，动态规划，时间负责度O(n^2)
状态：dp[i][j]代表i到j是否为回文串 1:是 0:否
状态转移：
若s[i] == s[j]且dp[i+1][j-1]==1 s[i][j]=1;否则s[i][j] = 0。若s[i][j]=1。记录i,j的最长距离

dp[i+1][j-1]位于左下角
所以遍历的是时候是从下到上
*/

public class LongestPalindromicSubstr{
    public static String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        int len = s.length();
        int dp[][] = new int[len][len];
        for(int j = 0; j < len; j++){
            char chj = s.charAt(j);
            
            for(int i = j; i >= 0; i--){
                char chi = s.charAt(i);
                if (chi == chj && (j-i <= 1 || dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    if (j-i+1 > max){
                        max = j-i+1;
                        res = s.substring(i,j+1);
                    }
                }else {
                    dp[i][j] = 0;
                }

            }
        }
        return res;
    }
     public static void main(String[] args) {
         System.out.println(longestPalindrome("cbbd"));
     }
}