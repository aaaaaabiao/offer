package leetcode.sort;
/**
 * @version: V1.0
 * @author: abiao
 * @className: FindKthLargest
 * @packageName: leetcode.sort
 * @description: 找到乱序数组中第K大的数
 * @data: 2019/1/15
 **/
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int val : nums){
            queue.offer(val);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.poll();
    }


    public int findKthLargest1(int[] nums, int k) {
        int l = 0;
        int h = nums.length-1;
        k = nums.length - k;
        while (l < h){
            int j = partition(nums,l,h);
            if (j == k){
                return nums[j];
            }else if(k > j){
                l = j+1;
            }else {
                h = j-1;
            }
        }
        return nums[k];
    }

    private int partition(int [] nums, int l, int h){
        int i = l;
        int j = h+1;
        while (true){
            //从前往后找到第一个大于nums[l]的元素
            while (nums[++i] < nums[l] && i < h);

            //从后往前找到第一个小于nums[l]的元素
            while (nums[--j] > nums[l] && j > l);

            if (i >= j){
                break;
            }
            swap(nums,i,j);
        }
        //注意最后是从后往前的指针,即j。因为要把小的放到最前面。
        swap(nums,l,j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args){
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest.findKthLargest1(nums,2));
    }
}
