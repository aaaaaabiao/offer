package offer;

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

        if (numbers == null) return false;
        Arrays.sort(numbers);
        int len = numbers.length;
        if (len == 0) return false;
        int zeroCount = 0;
        while (numbers[zeroCount] == 0){
            zeroCount++;
        }
        int needVal = numbers[zeroCount];
        for (int i = zeroCount; i < len;){
            if (numbers[i] == needVal){
                i++;
            }else {
                if (zeroCount > 0){
                    zeroCount--;
                }else {
                    return false;
                }
            }

            needVal++;
        }
        return true;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{5,4,7,0,1,2,9};
        System.out .println(isContinuous(numbers));
    }
}
