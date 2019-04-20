package leetcode.Array;

public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[40000];
        for (int x : A) {
            count[x]++;
        }
        int ans = 0;
        int remain = 0;
        for (int y : count) {
            ans += remain;
            y += remain;
            remain = y > 1 ? y - 1 : 0;
        }
        ans += remain * (remain + 1) / 2;
        return ans;
    }
}
