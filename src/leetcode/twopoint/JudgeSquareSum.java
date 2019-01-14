package leetcode.twopoint;
/**
 * @version: V1.0
 * @author: abiao
 * @className: JudgeSquareSum
 * @packageName: leetcode.twopoint
 * @description: 两树的平方和
 * @data: 2019/1/14
 **/
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int n = (int)Math.sqrt(c);
        int i = 0;
        int j = n;

        while (i <= j){
            int sum = i*i + j*j;
            if (sum == c) return true;
            else if (sum < c) i++;
            else j--;
        }
        return false;
    }
}
