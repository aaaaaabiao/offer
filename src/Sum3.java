import java.util.*;

public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++){
            int t1 = 0 - nums[i];
            Set<Integer> set = new HashSet();
            for (int j = i+1; j < nums.length; j++){
                int t2 = t1 - nums[j];
                if (set.contains(t2)){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(t2);
                    ls.add(nums[j]);
                    list.add(ls);
                }
                set.add(nums[j]);
            }
        }
        return list;
    }

    public static void main(String[] args){
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
