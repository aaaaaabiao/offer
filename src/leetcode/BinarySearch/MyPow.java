package leetcode.BinarySearch;
/**
 * @version: V1.0
 * @author: abiao
 * @className: MyPow
 * @packageName: leetcode.BinarySearch
 * @description: 求次方
 * @data: 2019/2/16
 **/
public class MyPow {
    public static double myPow(double x, int n) {
        double res = 0;
        int t = Math.abs(n);
        if (t == 0) return 1;
        if (t == 1) return n > 0 ? x : 1/x;
        if (t == 2) return n > 0 ? x*x : 1/(x*x);

        if (t % 2 == 0){
            res =  myPow(myPow(x,t/2),2);
        }else {
            res = myPow(myPow(x,t/2),2) * x;
        }

        return n > 0 ? res : 1/res;
    }

    public static double myPow1(double x, int n) {
        if(n == 0)
            return 1;
        if(n == Integer.MIN_VALUE){
            return myPow1(x*x, n/2);
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow1(x*x, n/2) : x*myPow1(x*x, n/2);
    }




    public static void main(String[] args){
        System.out.println(myPow(2.0,10));
        System.out.println(myPow(2.0,-2));
        System.out.println(myPow(2.0,-2147483648));
    }
}
