package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: Fibonacci
 * @packageName: offer
 * @description: 求fibonacci数列的第N项
 * @data: 2018/11/23
 **/
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args){
        for (int i = 0; i <= 39; i++){
            System.out.println(fibonacci(i));
        }
    }
}
