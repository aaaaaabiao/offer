package leetcode;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 给定 n 和 k，返回第 k 个排列。
 ````````````````````````````````````例子`````````````````````````````````````
 示例 1:

 输入: n = 3, k = 3
 输出: "213"
 示例 2:

 输入: n = 4, k = 9
 输出: "2314"
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/permutation-sequence/submissions/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：回溯法或者找规律
 描述：说一下找规律。

 直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
 可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
 算出来, 对于n=4, k=15 找到k=15排列的过程:

 1 + 对2,3,4的全排列 (3!个)
 2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
 3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
 4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

 确定第一位:
 k = 14(从0开始计数)
 index = k / (n-1)! = 2, 说明第15个数的第一位是3
 更新k
 k = k - index*(n-1)! = 2
 确定第二位:
 k = 2
 index = k / (n-2)! = 1, 说明第15个数的第二位是2
 更新k
 k = k - index*(n-2)! = 0
 确定第三位:
 k = 0
 index = k / (n-3)! = 0, 说明第15个数的第三位是1
 更新k
 k = k - index*(n-3)! = 0
 确定第四位:
 k = 0
 index = k / (n-4)! = 0, 说明第15个数的第四位是4
 最终确定n=4时第15个数为3214
 ````````````````````````````````````思考`````````````````````````````````````
 注意下标从0开始

 比如
 123 456 789
 找第3个数在哪个区间

 3/3 = 1....0，

 (3-1)/3 = 0....2。第0区间第3个数。这种情况符合

 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/7
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class GetPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(i);

        StringBuilder ret = new StringBuilder();
        k--;
        while(n > 0){
            int a = k / fact(n-1);
            int b = k % fact(n-1);

            ret.append(sb.charAt(a));
            sb.deleteCharAt(a);

            n--;
            k = b;
        }

        return ret.toString();
    }


    private int fact(int n){
        if(n == 0 || n == 1) return 1;
        return n*fact(n-1);
    }

    public static void main(String[] args){
        GetPermutation permutation = new GetPermutation();

        permutation.getPermutation(4,9);
    }
}
