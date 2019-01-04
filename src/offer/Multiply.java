package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: Multiply
 * @packageName: offer
 * @description: 构建乘积数组
 * @data: 2019/1/4
 **/
public class Multiply {
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0){
            return new int[0];
        }

        int len = A.length;
        if (len == 1){
            int[] ret = new int[]{1};
            return ret;
        }

        int[] arr1 = new int[len];
        int[] arr2 = new int[len];

        arr1[0] = 1;
        arr2[len-1] = 1;

        for (int i = 1; i < len; i++){
            arr1[i] = arr1[i-1]* A[i-1];
            arr2[len-1-i] = arr2[len-i]*A[len-i];
        }
        for (int i = 0; i < len; i++){
            arr1[i] *= arr2[i];
        }
        return arr1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        int[] ret = multiply(arr);
    }
}
