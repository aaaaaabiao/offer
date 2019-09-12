package offer.sort;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 输入一个数组,求出这个数组中的逆序对的总数P。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：采用归并排序的过程来算逆序对。
 描述：递归的求左边数组的逆序对+递归的求右边数组的逆序对+在meger函数中计算左边数组和右边数组和在一起的逆序对+
 ````````````````````````````````````思考`````````````````````````````````````
 合并的时候array[i] == array[j]逆序对该如何计算？
 把i跳过去。找到大于j的位置。计算前一个数组和j所构成的逆序对。

 如果要计算和i所构成的逆序对呢，这个时候i和j相等的时候应该移动j

 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class InversePairs {
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)return 0;
        return mergeCore(array,0,array.length-1)%1000000007;
    }

    public int mergeCore(int[] array,int l,int h){
        if(l < h){
            int mid = l + (h-l)/2;
            int left = mergeCore(array,l,mid);
            int right = mergeCore(array,mid+1,h);
            return left+right+merge1(array,l,mid,h);
        }else{
            return 0;
        }
    }

    public int merge1(int[] array,int l,int mid,int h){
        int[] buf = new int[h-l+1];
        int i = l;
        int j = mid+1;
        int res = 0;
        int n = 0;
        while(i <= mid && j <= h){
            if(array[i] <= array[j]){
                buf[n++] = array[i++];
            }else if(array[i] > array[j]){
                res += (mid-i+1);
//                res += (j-mid);
                buf[n++] = array[j++];
            }
        }

        if(i <= mid){
            while(i <= mid){
                buf[n++] = array[i++];
            }
        }

        if(j <= h){
            while(j <= h){
                buf[n++] = array[j++];
            }
        }

        for(int p = 0; p < buf.length; p++){
            array[l+p] = buf[p];
        }
        return res;
    }
}
