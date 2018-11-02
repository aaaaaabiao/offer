/*
*思想：如果是回文，把整数值倒过来的值也一样
*
* */

public class IntegerIsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num = x;
        int reverse = 0;
        while (num != 0){
            int tail = num % 10;
            reverse = reverse * 10 + tail;
            num = num / 10;
        }
        if (reverse == x)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(-121));
    }
}
