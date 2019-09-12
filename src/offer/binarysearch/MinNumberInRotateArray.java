package offer.binarysearch;

/**
 * @version: V1.0
 * @author: abiao
 * @className: MinNumberInRotateArray
 * @packageName: offer
 * @description: 求旋转数组的最小值
 * @data: 2018/11/21
 **/
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null && array.length == 0) {
            return -1;
        }

        int l = 0;
        int h = array.length - 1;
        while (l < h) {
            int mid = l + (h-l) / 2;
            if (array[mid] < array[h]) {
                h = mid;
            }else {
                l = mid + 1;
            }
        }
        return array[h];
    }

    public static void main(String[] args){
        int[] arr = {6501,6828,6963,7036,7422,7674,8146,8468,
                8704,8717,9170,9359,9719,9895,9896,9913,9962,154,
                293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,
                2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,
                5668,5706,5725,6300,6335};
        System.out.println(minNumberInRotateArray(arr));
    }
}
