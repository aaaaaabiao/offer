package offer.array;

import java.util.HashSet;
import java.util.Set;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 ````````````````````````````````````例子`````````````````````````````````````
 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 如果是找到数组中全部重复的数呢？
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/2
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class ArrayDuplicateNumber {
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if(nums == null || nums.length == 0) return false;
        for (int i = 0; i < length;){
            if(nums[i] == i){
                i++;
            }else{
                int val = nums[i];
                if(nums[val] == val){
                    duplication[0] = val;
                    return true;
                }
                //不断交换,使值和下标相等
                swap(nums,val,i);
            }
        }
        return false;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //如果是找到数组中全部重复的数呢
    public Set<Integer> allduplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums == null || nums.length == 0) return set;
        int length = nums.length;

        for (int i = 0; i < length;){
            if(nums[i] == i){
                i++;
            }else{
                int val = nums[i];
                if(nums[val] == -1){
                    nums[val] = val;
                    i++;
                }else{
                    if(nums[val] == val){
                        nums[i] = -1;
                        set.add(val);
                        i++;
                    }else{
                        swap(nums,val,i);
                    }
                }
            }
        }
        return set;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,2,3,5,6,1,4,5,3};
        ArrayDuplicateNumber duplicate = new ArrayDuplicateNumber();
        for (int val : duplicate.allduplicate(nums)){
            System.out.println(val);
        }
    }
}
