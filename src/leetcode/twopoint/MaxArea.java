package leetcode.twopoint;

/**
 * Created by 73681 on 2019/3/11.
 */
public class MaxArea {
    public static int maxArea(int[] height){
        if (height == null || height.length == 0 || height.length == 1) return 0;
        int l = 0;
        int h = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (l < h){
            int v1 = height[l];
            int v2 = height[h];
            int area = (h-l)*Math.min(v1,v2);
            max = Math.max(max,area);
            if (height[l] <= height[h]){
                while (l < h && height[l] <= v1) l++;
            }else{
                while (h > l && height[h] <= v2) h--;
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,3,4,5,18,17,6};
        System.out.println(maxArea(arr));
    }
}
