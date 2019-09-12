package offer.array;

import java.util.Arrays;
/**
 * @version: V1.0
 * @author: abiao
 * @className: IsContinuous
 * @packageName: offer
 * @description: 扑克牌顺序
 * @data: 2018/12/29
 **/
public class IsContinuous {
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        //排序
        Arrays.sort(numbers);
        int cnt = 0;
        //统计0的个数
        for (int val : numbers) {
            if (val == 0) {
                cnt++;
            }
        }
        //减去0的个数
        for (int i = cnt; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i+1]) {
                return false;
            }
            cnt -= (numbers[i+1] - numbers[i] - 1);
        }

        return cnt > 0;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{5,4,7,0,0,0,0,0,0,0,0,0,0,0,1,2,9};
        System.out .println(isContinuous(numbers));
    }
}
