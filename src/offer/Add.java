package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

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


    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList();
        if(num == null || size > num.length - 1) return ret;
        int len = num.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)-> o2-o1);
        int i = 0;
        int j = size-1;
        for(int n = 0; n < size; n++){
            queue.add(num[n]);
        }
        ret.add(queue.peek());
        i++;
        j++;
        while(j < len){
            queue.remove(num[i]);
            queue.add(num[j]);
            ret.add(queue.peek());
            i++;
            j++;
        }

        return ret;
    }

    public static void main(String[] args){
        int[] data = new int[]{2,3,4,2,6,2,5,1};
        maxInWindows(data,3);
        System.out.println(add(0,1));
    }



}
