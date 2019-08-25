package offer.array;
/**
 * @version: V1.0
 * @author: abiao
 * @className: Multiply
 * @packageName: offer
 * @description: 构建乘积数组，给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
 * @data: 2019/1/4
 **/
public class Multiply {
    public static int[] multiply(int[] A) {
        if (A == null || A.length <= 0) return A;
        int len = A.length;
        int[] B = new int[len];
        for (int i = 0, product = 1; i < len; i++){
            B[i] = product;
            product *= A[i];
        }

        for (int i = len-1, product = 1; i >= 0; i--) {
            B[i] *= product;
            product *= A[i];
        }

        return B;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        int[] ret = multiply(arr);
        int a = 0;
    }
}
