package offer.dp;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 n个骰子的个数
 ````````````````````````````````````例子`````````````````````````````````````
 输入：n = 1
 输出：[[1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]]
 解释：掷一次骰子，向上的数字和可能为1,2,3,4,5,6，出现的概率均为 0.17。


 输入：n = 2
 输出：[[2,0.03],[3,0.06],[4,0.08],[5,0.11],[6,0.14],[7,0.17],[8,0.14],[9,0.11],[10,0.08],[11,0.06],[12,0.03]]
 解释：掷两次骰子，向上的数字和可能在[2,12]，出现的概率是不同的。
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.lintcode.com/problem/dices-sum/description
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：动态规划
 描述：

 dp[i][j]为前i个骰子，和为j的个数。

 dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3] + dp[i-1][j-4] + dp[i-1][j-5] + dp[i-1][j-6]

 最后的结果为二维数组的最后一行。dp[n][j]/pow(6,n)。n个色子和为j的的个数。
 ````````````````````````````````````思考`````````````````````````````````````

 空间优化，使用一个旋转数组。
 long[][] dp = new long[2][pointNum + 1];2个一维数组，每次用到一个。
 每一用一个区更新另一个。
 注意更新一个前先清空这一个里面的数据。

 使用这种方式实现旋转。
 int flag = 1;
 for (int i = 2; i <= n; i++, flag = 1 - flag){

 }
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/8
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class DicesSum {

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        int totalSum = 6*n;
        int[][] dp = new int[n+1][totalSum+1];//dp[i][j]代表前i个骰子和为j的个数
        for (int i = 0; i < 6; i++){
            dp[1][i] = 1;
        }
        for (int i = 2; i < n; i++){
            for (int j = 1; j <= totalSum; j++){
                for (int p = 1; p <= 6 && p < j; p++){
                     dp[i][j] = dp[i-1][j-p];
                }
            }
        }
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        int total = (int) Math.pow(6,n);
        for (int i = 1; i <= totalSum; i++){
            ret.add(new AbstractMap.SimpleEntry<Integer,Double>(i, (double)dp[n][i] / total));
        }
        return ret;
    }
}
