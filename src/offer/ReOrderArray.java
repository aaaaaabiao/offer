package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version: V1.0
 * @author: abiao
 * @className: ReOrderArray
 * @packageName: offer
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *               使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *               并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @description： 从头开始遍历，发现一个偶数，将后面的数全部向前移一位，并将该偶数放在最后。这种方式不行
 *                因为你在移动的时候，影响到你后面遍历的数了。
 *
 *                考虑将奇数向前插。前插就不会影响后面遍历的后面要遍历的数据了
 * @data: 2018/11/29
 **/
public class ReOrderArray {

    //不采用额外的辅助空间
    public static void reOrderArray(int [] array) {
        int len = array.length;
        boolean flag = true;
        int p = 0;//第一个偶数的位置
        for (int i = 0; i < len; i++){
            if (array[i] % 2 == 0 && flag){
                flag = false;
                p = i;
                continue;
            }

            if (array[i] % 2 != 0 && !flag){
                int tmp = array[i];
                for (int j = i; j > p; j--){
                    array[j] = array[j-1];
                }
                array[p] = tmp;
                p++;
            }
        }
    }
    
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,6};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }
}
