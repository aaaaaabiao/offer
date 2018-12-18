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

    public static void main(String[] args){
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        List ret = getLeastNumbers(input,4);
        int a = 0;
    }
}
