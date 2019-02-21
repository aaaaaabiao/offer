package leetcode.dp;
/**
 * @version: V1.0
 * @author: abiao
 * @className: NumTrees
 * @packageName: leetcode.dp
 * @description: 二叉搜索树的种类
 * @data: 2019/2/21
 **/
public class NumTrees {
    //recursive
    public static int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int res = 0;
        for (int i = 1; i <= n; i++){
            res += (numTrees(i-1)*numTrees(n-i));
        }

        return res;
    }

    //dp
    public static int numTrees1(int n){
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n; i++){
            int p = 0;
            int q = i-1;
            while (p < q){
                dp[i] += dp[p++]*dp[q--];
            }

            dp[i] *= 2;
            if (p == q){
                dp[i] += (dp[q]*dp[q]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(numTrees(3));
//        System.out.println(numTrees1(3));
        System.out.println(numTrees1(5));
    }
}
