package leetcode.Array;

/**
 * 两个排序数组的中位数
 * 问题转化：求两个排序数组中的第K的大数
 * 时间复杂度：每进行一次循环，减少 k/2 个元素，所以时间复杂度是 O(log(k)，而 k = (m+n) / 2，所以最终的复杂也就是 O(log(m+n）。
 * @author hubiao
 */
public class SortArrayMedian {
    public static double findSortArrayMedia(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int l = l1 + l2;
        if (l % 2 == 0) {
            return (double) (findK(arr1, 0, l1-1, arr2,0, l2-1, (l1+l2)/2)
                    + findK(arr1, 0, l1-1, arr2, 0, l2-1, (l1+l2)/2 + 1)) / 2;
        }else {
            return findK(arr1, 0, l1-1, arr2, 0, l2-1, (l1+l2)/2 + 1);
        }
    }


    public static int findK(int[] arr1, int s1, int e1, int [] arr2, int s2, int e2, int k) {
        int l1 = e1 - s1 + 1;
        int l2 = e2 - s2 + 1;
        //保证arr1数组是长度小的数组
        if (l1 > l2) return findK(arr2, s1, e2, arr1, s1, e1, k);
        if (l1 == 0) return arr2[s2 + k - 1];
        if (k == 1) return Math.min(arr1[s1], arr2[s2]);

        int i = s1 + Math.min(l1, k/2) - 1;
        int j = s2 + Math.min(l2, k/2) - 1;

        if (arr1[i] < arr2[j]) {
            k = k - (i - s1 + 1);
            return findK(arr1, i + 1, e1, arr2, s2, e2, k);
        }else{
            k = k - (j - s2 + 1);
            return findK(arr1, s1, e1, arr2, j+1, e2, k);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,7};
        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9,10};

        System.out.println(findSortArrayMedia(arr1, arr2));
    }
}
