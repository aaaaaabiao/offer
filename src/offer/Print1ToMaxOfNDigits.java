package offer;

/**
 * Created by 73681 on 2019/3/10.
 * 打印从 1 到最大的 n 位数
 */
public class Print1ToMaxOfNDigits {
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return;
        char[] nums = new char[n];
        backtracing(nums,0);
    }
    public static void backtracing(char[] nums, int len){
        if (len == nums.length){
            printDigit(nums);
            return;
        }
        for (int i = 0; i < 10; i++){
            nums[len] = (char)(i+'0');
            backtracing(nums,len+1);
        }
    }
    public static void printDigit(char[] nums){
        int p = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != '0'){
                p = i;
                break;
            }
        }
        if (p != -1){
            System.out.println(new String(nums,p,nums.length-p)) ;
        }
    }
    public static void main(String[] args){
        print1ToMaxOfNDigits(2);
    }
}
