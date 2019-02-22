package leetcode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * @version: V1.0
 * @author: abiao
 * @className: KClosest
 * @packageName: leetcode.sort
 * @description: 最接近原点的K个数组
 * @data: 2019/2/22
 **/
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int v1 = o1[0]*o1[0] + o1[1]*o1[1];
                int v2 = o2[0]*o2[0] + o2[1]*o2[1];
                return v2-v1;
            }
        });


        for (int[] arr : points){
            queue.add(arr);
            if (queue.size() > K){
                queue.poll();
            }
        }

        int[][] res = new int[K][2];

        for (int i = K-1; i >= 0; i--){
            res[i] = queue.poll();
        }
        return res;
    }
}
