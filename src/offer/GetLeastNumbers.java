package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @version: V1.0
 * @author: abiao
 * @className: GetLeastNumbers
 * @packageName: offer
 * @description: 最小的K个数字，使用优先级队列(堆)。时间复杂度为O(nlogk)
 * @data: 2018/12/18
 **/
public class GetLeastNumbers {
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
