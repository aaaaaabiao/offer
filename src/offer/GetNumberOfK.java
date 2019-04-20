package offer;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 统计一个数字在排序数组中出现的次数。
 ````````````````````````````````````例子`````````````````````````````````````
 Input:
 nums = 1, 2, 3, 3, 3, 3, 4, 6
 K = 3

 Output:
 4
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：二分查找
 描述：找到数组中第一个大于等于K的元素位置为p。如果p < array.length && array[p] == k 说明数组中存在元素K。否则存在
 再在数组中找到第一个大于等于K+1的元素q。结果为q-p。
 ````````````````````````````````````思考`````````````````````````````````````

 找到数组中第一大于等于K的元素,很经典的二分查找的模板。
 注意初值为l = 0, h = array.length;
 当k大于数组中的全部元素时，会返回len。代表未找到。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/6
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class GetNumberOfK {

    public static int getNumberOfK1(int [] array , int k) {
        int len = array.length;
        if (len == 0) return 0;
        int p = binarySearch(array,k);
        if (p == array.length || array[p] != k) return 0;
        int q = binarySearch(array,k+1);
        return q-p;
    }



    //找到数组中第一大于等于K的元素
    public static int binarySearch(int[] array,int k){
        int l = 0;
        int h = array.length;
        while (l < h){
            int mid = l + (h-l)/2;
            if(k <= array[mid]){
                h = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }



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
