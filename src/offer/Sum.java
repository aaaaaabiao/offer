package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: Sum
 * @packageName: offer
 * @description: 求1+2+3+...+n,用递归代替累加，短路代替终止条件
 * @data: 2019/1/2
 **/

public class Sum {
    public static int sum(int n) {
        int res = n;
        boolean b = (n > 0) && (res += sum(n-1)) > 0;
        return res;
    }

    public static void main(String[] args){
        System.out.println(sum(10));
    }
}
