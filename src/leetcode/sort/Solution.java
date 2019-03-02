package leetcode.sort;

import java.util.Arrays;

/**
 * Created by 73681 on 2019/3/1.
 */
public class Solution {
    //快速排序
    public void quickSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        core(arr,0,arr.length-1);
    }

    public void core(int[] arr,int l,int h){
        if (l < h){
            int p = partion(arr,l,h);
            core(arr,l,p-1);
            core(arr,p+1,h);
        }

    }

    public int partion(int[] arr,int l,int h){
        int i = l;
        int j = h+1;
        int val = arr[l];
        while (true){
            //从前往后找,找到第一个大于val的值
            while (arr[++i] <= val && i < h);
            //从后往前找,找到第一个小于val的值
            while (arr[--j] >= val && j > l);

            if (i >= j) break;
            //交换位置
            swap(arr,i,j);
        }
        swap(arr,l,j);
        return j;
    }

    public void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //归并排序
    public void mergeSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        mergeSortCore(arr,0,arr.length-1);
    }

    public void mergeSortCore(int[] arr,int l,int h){
        if (l < h){
            int mid = l + (h-l)/2;
            mergeSortCore(arr,l,mid);
            mergeSortCore(arr,mid+1,h);
            merge(arr,l,mid,h);
        }
    }

    public void merge(int[] arr,int l,int mid,int h){
        int[] buf = new int[h - l + 1];
        int p = 0;
        int i = l;
        int j = mid+1;
        while (i <= mid && j <= h){
            if (arr[i] <= arr[j]){
                buf[p++] = arr[i++];
            }else{
                buf[p++] = arr[j++];
            }
        }

        if (i <= mid){
            while (i <= mid){
                buf[p++] = arr[i++];
            }
        }

        if (j <= h){
            while (j <= h){
                buf[p++] = arr[j++];
            }
        }

        for (int n = 0; n < buf.length; n++){
            arr[l+n] = buf[n];
        }
    }

    public static void printArr(int[] arr){
        for (int val : arr){
            System.out.println(val);
        }
    }




    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = new int[]{2,4,1,5,3,7,1};
//        solution.quickSort(arr);
        solution.mergeSort(arr);
        printArr(arr);
    }
}
