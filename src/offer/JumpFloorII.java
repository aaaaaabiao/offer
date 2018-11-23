package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: JumpFloorII
 * @packageName: offer
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @data: 2018/11/23
 **/
public class JumpFloorII {
    public static int jumpFloorII(int target) {
        if (target == 1) return 1;
        int a = 1;
        int b = 0;
        for (int i = 2; i <= target; i++){
            b = 2*a;
            a = b;
        }
        return b;
    }

    public static void main(String[] args){
        for (int i = 1; i <= 10; i++){
            System.out.println(jumpFloorII(i));
        }
    }
}
