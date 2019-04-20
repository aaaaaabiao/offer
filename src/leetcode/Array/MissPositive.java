package leetcode.Array;

public class MissPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int len = nums.length;
        for(int i = 0; i < len;){
            if(nums[i] >= 1 && nums[i] <= len && nums[i] != i+1 && nums[nums[i]-1] != nums[i]){
                int p = nums[i];
                swap(nums,p-1,i);
            }else{
                i++;
            }
        }

        int ret = len+1;
        for(int i = 0; i < len; i++){
            if(nums[i] != i+1) ret = i+1;
        }
        return ret;
    }

    public void swap(int[] nums, int p,int q){
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    public static void main(String[] args){
        MissPositive missPositive = new MissPositive();
        System.out.println(missPositive.firstMissingPositive(new int[]{1,1}));
    }
}
