package offer;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。
 ````````````````````````````````````例子`````````````````````````````````````
 例如，对于如下棋盘
 1    10   3    8
 12   2    9    6
 5    7    4    11
 3    7    16   5

 礼物的最大价值为 1+12+5+7+7+16+5=53。
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：动态规划
 描述：dp[i][j]代表到第i,j位置的所能拿打的最大值。
 dp[i][j] = max(dp[i-1][j],dp[i][j-1]。左边位置的值和上边位置的值比较。
 ````````````````````````````````````思考`````````````````````````````````````
 其实这个题目采用一个一维的辅助空间就可以做了。就是和上一个状态和当前状态左边的值有关。在一维数组中，左边的值被更新了，上一个状态的值还未被污染。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class GetMost {
    public int getMost(int[][] values){
        if (values == null || values.length == 0) return 0;
        int len = values[0].length;
        int[] dp = new int[len];

        for (int[] value : values){
            dp[0] += value[0];
            for (int i = 1; i < len; i++){
                dp[i] = Math.max(dp[i-1],dp[i]) + value[i];
            }
        }
        return dp[len-1];
    }
}
