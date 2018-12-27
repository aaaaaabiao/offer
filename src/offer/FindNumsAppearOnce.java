package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: FindNumsAppearOnce
 * @packageName: offer
 * @description: 找到数组中2个只出现过一次的数，其他数均出现过两次
 * @data: 2018/12/27
 **/
public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        if (len == 0 || len == 1 || len % 2 == 1) return;
        int res = array[0];
        for (int i = 1; i < array.length; i++){
            res ^= array[i];
        }

        int index = 0;
        while (res != 0){
            if ((res & 0x00000001) == 1){
                break;
            }
            index++;
            res = res >> 1;
        }

        num1[0] = 0;
        num2[0] = 0;
        int val = 0x00000001 << index;

        for (int i = 0; i < array.length; i++){
            int a = array[i];
            if ((a & val) == 0){
                num1[0] ^= a;
            }else {
                num2[0] ^= a;
            }
        }
    }
}
