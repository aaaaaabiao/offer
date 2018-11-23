package offer;

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
        if (array == null || array.length == 0) return 0;
        int res = core(array,0,array.length-1);
        return res == 0 ? array[0]:res;
    }

    public static int core(int[] array,int start,int end){

        if (start > end) return 0;

        int mid = (start + end)/2;
        if (mid-1 > 0 && array[mid-1] > array[mid]) return array[mid];
        if (mid+1 < array.length && array[mid] > array[mid+1]) return array[mid+1];

        int left = core(array,start,mid-1);
        int right = core(array,mid+1,end);

        int res = Math.max(left,right);
        return res;
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
