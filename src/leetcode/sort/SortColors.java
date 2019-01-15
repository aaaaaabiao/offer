package leetcode.sort;
/**
 * @version: V1.0
 * @author: abiao
 * @className: SortColors
 * @packageName: leetcode.sort
 * @description: 按颜色进行排序
 * @data: 2019/1/15
 **/
public class SortColors {
    public void sortColors(int[] nums) {
        int zero = -1;
        int one = 0;
        int two = nums.length;

        while (one < two){
            if (nums[one] == 0){
                zero++;
                swap(nums,zero,one);
                one++;
            }else if (nums[one] == 2){
                two--;
                swap(nums,one,two);
            }else{
                one++;
            }
        }
    }

    private void swap(int[] nums,int p,int q){
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    public static void main(String[] args){
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors.sortColors(nums);

        int a;
    }
}
