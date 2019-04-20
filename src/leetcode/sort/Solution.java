package leetcode.sort;

/***
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

    private int partion(int[] arr, int l, int h){
        int i = l;
        int j = h+1;
        int val = arr[l];
        while (true){
            //从前往后找,找到第一个大于val的值
            while (i < h && arr[++i] <= val);
            //从后往前找,找到第一个小于val的值
            while (j > l && arr[--j] >= val );

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




    //调整堆（自顶向下调整）
    public void MinHeapFixdown(int a[],int i, int n){
        int j = 2*i+1;
        int tmp;
        while (j < n){
            //在左右子节点中寻找最小的，这个地方决定迭代的j是否+1
            if(j+1<n && a[j+1]<a[j]){
                j++;
            }
            if(a[i] <= a[j])
                break;
            //较大节点下移
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i = j;
            j = 2*i+1;
        }
    }
    /*
     * 建立小根堆
     * */
    public void MakeMinHeap(int a[], int n){
        for (int i = n/2 - 1; i >= 0; i--){
            MinHeapFixdown(a,i,n);
        }
    }
    /*堆排序*/
    public void heapSort(int a[]){
        int len = a.length;
        MakeMinHeap(a,len);
        int tmp = 0;
        for (int i = len-1; i > 0; i--){
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            //长度len-1，下标为len-2
            MinHeapFixdown(a,0,i);
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = new int[]{2,4,1,5,3,7,1};
        int[] arr1 = new int[]{1,2,3,4,5,6};
//        solution.quickSort(arr);
//        solution.mergeSort(arr);
        solution.heapSort(arr);
        printArr(arr);

        StringBuilder stringBuilder = new StringBuilder();
    }
}
