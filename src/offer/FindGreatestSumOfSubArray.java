package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: FindGreatestSumOfSubArray
 * @packageName: offer
 * @description: 连续子数组最大和
 * @data: 2018/12/19
 **/
public class FindGreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int ret = 0;
        for (int i = 0; i < array.length; i++){
            int val = array[i];
            if (ret < 0){
                ret = val;
            }else {
                ret += val;
            }
            max = ret > max ? ret : max;
        }
        return max;
    }
}
