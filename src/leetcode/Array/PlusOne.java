package leetcode.Array;

/**
 * @version: V1.0
 * @author: abiao
 * @className: PlusOne
 * @packageName: leetcode.Array
 * @description: https://leetcode.com/problems/plus-one/
 * @data: 2019/2/15
 **/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len-1] == 9){
            int n = 1;
            digits[len-1] = 0;
            for (int i = len-2; i >= 0; i--){
                int val = digits[i] + n;
                if (val >= 10){
                    digits[i] = val - 10;
                    n = 1;
                }else {
                    digits[i] = val;
                    n = 0;
                }
            }
            if (n == 1){
                int[] res = new int[len+1];
                res[0] = 1;
                for (int p = 0; p < len; p++){
                    res[p+1] = digits[p];
                }
                return res;
            }

        }else {
            digits[len-1] += 1;
        }
        return digits;
    }
}
