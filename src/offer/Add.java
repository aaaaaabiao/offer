package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: Add
 * @packageName: offer
 * @description: 求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @data: 2019/1/2
 **/
public class Add {
    /**
     *  1.各位相加不进，异或
     *  2.进位，与后左移一位
     *  3.结果为1+2.(1+2的步骤同上一样。终止条件是没有进位)
     *
    */
    public static int add(int num1,int num2) {
        while (num2 != 0){
            int a = num1;
            int b = num2;
            num1 = a ^ b;
            num2 = (a & b) << 1;
        }
        return num1;
    }

    public static void main(String[] args){
        System.out.println(add(0,1));
    }
}
