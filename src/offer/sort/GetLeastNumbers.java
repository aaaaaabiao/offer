package offer.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入n个整数，找出其中最小的K个数。
 ````````````````````````````````````例子`````````````````````````````````````
 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：使用堆，时间复杂度为O（nlogk）空间复杂度O(k)
 描述：维护大小为K一个大顶堆（优先级队列）。依次进队。最后剩下的就最小的K个数字。

 方法：使用快排的思想。O(n)时间复杂度,空间复杂度O(1)
 描述：通过partion函数找到第K大的数字。第K小的数字的左边都小K。注意第K小的数字。其实就是第K-1的位置。
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class GetLeastNumbers {

    /**
     * 使用大顶堆
     * */
    public static ArrayList<Integer> getLeastNumbers(int [] input, int k) {

        if (input.length < k || k == 0){
            return new ArrayList<>();
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < input.length; i++){
            int value = input[i];
            if (maxHeap.size() < k){
                maxHeap.add(value);
            }else {
                if (value < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(value);
                }
            }
        }
        return new ArrayList<>(maxHeap);
    }

    //快速排序思想解决
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList();
        if(input == null || input.length == 0 || k > input.length) return ret;
        int n = findMinkNums(input,k);
        for(int i = 0; i < k; i++){
            ret.add(input[i]);
        }
        return ret;
    }

    public int findMinkNums(int[] input,int k){
        int l = 0;
        int h = input.length - 1;
        while(l < h){
            int mid = partion(input,l,h);
            if(mid == k-1){
                return input[mid];
            }else if(k-1 < mid){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public int partion(int[] input,int l,int h){
        int i = l;
        int j = h+1;
        int val = input[l];

        while(true){
            while(input[++i] <= val && i < h);
            while(input[--j] >= val && j > l);

            if(i >= j){
                break;
            }
            swap(input,i,j);
        }

        swap(input,l,j);
        return j;
    }

    public void swap(int[] input,int i,int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args){
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        List ret = getLeastNumbers(input,4);

        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        List ret1 = getLeastNumbers.GetLeastNumbers_Solution(input,4);
        int a = 0;
    }
}
