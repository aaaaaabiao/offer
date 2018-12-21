package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: GetNumberOfK
 * @packageName: offer
 * @description: 数字在排序数组中出现的次数(二分法)
 * @data: 2018/12/21
 **/
public class GetNumberOfK {
    public static int getNumberOfK(int [] array , int k) {
        int len = array.length;
        if (len == 0) return 0;
        return core(array,0,len-1,k);
    }

    public static int core(int[] array,int start, int end,int k){
        if (start > end) return 0;
        if (start == end){
            return array[start] == k ? 1 : 0;
        }
        int mid = (start + end)/2;
        int leftCount = core(array,start,mid-1,k);
        int rightCount = core(array,mid+1,end,k);
        int midCount = array[mid] == k ? 1 : 0;
        return leftCount + rightCount + midCount;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,1,1,2,2,3,4,5};
        System.out.println(getNumberOfK(array,1));
    }
}
