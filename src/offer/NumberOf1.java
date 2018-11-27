package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: NumberOf1
 * @packageName: offer
 * @description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @data: 2018/11/26
 **/
public class NumberOf1 {
    public static int NumberOf1(int n) {
        int c = 0;
        while (n != 0) {
            c = (n & 0x00000001) == 1 ? c + 1 : c;
            n = n >>> 1;
        }
        return c;
    }

    public static void  main(String[] args){
        System.out.println(NumberOf1(1));
        System.out.println(NumberOf1(2));
        System.out.println(NumberOf1(3));
        System.out.println(NumberOf1(-1));
        System.out.println(NumberOf1(-2));
        System.out.println(NumberOf1(-3));
    }
}
