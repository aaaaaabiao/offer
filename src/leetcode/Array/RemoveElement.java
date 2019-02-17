package leetcode.Array;
/**
 * @version: V1.0
 * @author: abiao
 * @className: RemoveElement
 * @packageName: leetcode.Array
 * @description: 删除重复元素
 * @data: 2019/2/17
 **/
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 0;
        int len = nums.length;
        while (p < len && q < len){
            if (nums[q] != val){
                nums[p++] = nums[q];
            }
            q++;
        }
        return p;
    }

    public static void main(String[] args){

    }
}
