package leetcode.sort;

/**
 * @version: V1.0
 * @author: abiao
 * @className: SortedSquares
 * @packageName: leetcode.sort
 * @description: https://leetcode.com/problems/squares-of-a-sorted-array/
 * @data: 2019/2/22
 **/
public class SortedSquares {
    public static int[] sortedSquares(int[] A) {
        int len = A.length;
        int p = 0;
        int q = len - 1;
        int[] res = new int[len];
        int i = len-1;
        while (p <= q){
            if (Math.abs(A[p]) < Math.abs(A[q])){
                res[i--] = A[q]*A[q];
                q--;
            }else{
                res[i--] = A[p]*A[p];
                p++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = new int[]{-4,-1,0,3,10};
        int[] arr1 = new int[]{-7,-3,2,3,11};
        int[] res = sortedSquares(arr);
        int[] res1 = sortedSquares(arr1);
        int a;
    }
}
