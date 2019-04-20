package leetcode.string;

public class Multiply {
    public static String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] nums = new int[l1+l2];
        int l = nums.length;
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        for(int i = l1 - 1; i >= 0; i--){
            int p = nums.length-l1+i;
            for(int j = l2 - 1; j >= 0; j--){
                nums[p--] += (chs1[i]-'0')*(chs2[j]-'0');
            }
        }
        int p = 0;
        while(p < l && nums[p] == 0)p++;
        System.out.println(p);
        String str = "";
        int n = 0;
        for(int i = l - 1; i >= p; i--){
            int val = nums[i] + n;
            n = val / 10;
            int m = val % 10;
            str = m + str;
        }
        if(n > 0) str = n + str;
        return str;
    }

    public static void main(String[] args){
        System.out.println(multiply("2","12"));
    }
}
