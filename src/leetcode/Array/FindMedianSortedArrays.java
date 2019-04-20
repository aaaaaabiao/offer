package leetcode.Array;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int l1 = 0,r1 = 0,l2 = 0,r2 = 0,c1 = 0,c2 = 0,lo = 0,hi = 2*n;
        while(lo <= hi){
            c1 = (lo+hi)/2;
            c2 = m+n-c1;
            l1 = (c1 == 0) ? Integer.MIN_VALUE:nums1[(c1-1)/2];
            r1 = (c1 == 2*n) ? Integer.MAX_VALUE:nums1[c1/2];
            l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2-1)/2];
            r2 = (c2 == 2*m) ? Integer.MAX_VALUE : nums2[c2/2];

            if(l1 > r2){
                hi = c1-1;
            }else if(l2 > r2){
                lo = c1+1;
            }else{
                break;
            }
        }
        return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
    }


    //找到两个排序数组中第K大的数
    public static int findKstIn2Array(int[] nums1,int[] nums2,int k){
        int n = nums1.length;
        int m = nums2.length;
        int l1 = 0;
        int r1 = 0;
        int l2 = 0;
        int r2 = 0;
        int l = 0;
        int h = n;
        while (l <= h){
            l1 = (l+h)/2;
            r1 = l1 < n-1 ? l1+1 : Integer.MAX_VALUE;

            l2 = k - l1 - 2;
            r2 = l2+1;
            if(l2 > m-1 || r2 > m-1) {
                l2 = Integer.MAX_VALUE;
                r2 = Integer.MAX_VALUE;
            }

            if(l1 > r2){
                h = l1-1;
            }else if(l2 > r1){
                l = l1+1;
            }else{
                break;
            }
        }
        return Math.max(nums1[l1],nums2[l2]);
    }



    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int size = len1 + len2;
        if(size % 2 == 1)
            return findKth(nums1, 0, len1, nums2, 0, len2, size / 2 + 1);
        else
            return (findKth(nums1, 0, len1, nums2, 0, len2, size / 2) + findKth(nums1, 0, len1, nums2, 0, len2, size / 2 + 1)) /2;
    }
    public double findKth(int[] nums1, int start1, int len1, int[] nums2, int start2, int len2, int k)
    {
        if(len1 - start1 > len2 -start2)  // 传进来的时候统一让短的数组为nums1
            return findKth(nums2, start2, len2, nums1, start1, len1, k);
        if(len1 - start1 == 0)  // 表示nums1已经全部加入前K个了，第k个为nums2[k - 1];
            return nums2[k - 1];
        if(k == 1)
            return Math.min(nums1[start1], nums2[start2]); // k==1表示已经找到第k-1小的数，下一个数为两个数组start开始的最小值
        int p1 = start1 + Math.min(len1 - start1, k / 2); // p1和p2记录当前需要比较的那个位
        int p2 = start2 + k - (p1 - start1);//意思是(p1-start) + (p2 - start2) = k;
        if(nums1[p1 - 1] < nums2[p2 - 1])
            return findKth(nums1,  p1, len1, nums2, start2, len2, k - (p1 - start1));
        else if(nums1[p1 - 1] > nums2[p2 -1])
            return findKth(nums1, start1, len1, nums2, p2, len2, k - (p2 - start2));
        else
            return nums1[p1 - 1];
    }


    public static void main(String[] args){
        int[] nums1 = new int[]{1,4,7,9};
        int[] nums2 = new int[]{2,3,5};
        double a = findMedianSortedArrays(nums1,nums2);
        double c = findKstIn2Array(nums2,nums1,1);
        int b = 0;
    }
}
