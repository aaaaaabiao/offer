package offer.dp;

/**
 * @version: V1.0
 * @author: abiao
 * @className: JumpFloor
 * @packageName: offer
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * @data: 2018/11/23
 **/
public class JumpFloor {
    public static int jumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= target; i++){
            int tmp = b;
            b = a+b;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args){
        for (int i = 1; i <= 39; i++){
            System.out.println(jumpFloor(i));
        }
    }
}
