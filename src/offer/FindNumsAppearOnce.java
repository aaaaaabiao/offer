package offer;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：位运算
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 a == b -> a ^ b = 0
 a &= -a -> 保留a中第一个1（从后往前数）其他全为0
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/6
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class FindNumsAppearOnce {


    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;//0和任何一个数异或都为那个数
        for(int val : array){
            diff ^= val;
        }
        diff &= -diff;
        for(int val : array){
            if((val & diff) == 0){
                num1[0] ^= val;
            }else{
                num2[0] ^= val;
            }
        }
    }

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
