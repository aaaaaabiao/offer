import java.util.logging.Level;

/*
* 排序数组中不重复值的数
* */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int val = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++){
            if (val != nums[i]){
                nums[res] = nums[i];
                val = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
