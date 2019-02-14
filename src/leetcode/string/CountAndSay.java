package leetcode.string;
/**
 * @version: V1.0
 * @author: abiao
 * @className: CountAndSay
 * @packageName: leetcode.string
 * @description: https://leetcode.com/problems/count-and-say/
 * @data: 2019/2/14
 **/
public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String res = "1";
        for (int i = 2; i <= n; i++){
            res = translate(res);
        }
        return res;
    }
    public static String translate(String str){
        StringBuffer res = new StringBuffer();
        char[] arr = str.toCharArray();
        int n = 1;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] == arr[i-1]){
                n++;
            }else {
                res.append(n+""+arr[i-1]);
                n = 1;
            }
        }
        res.append(n+""+arr[arr.length-1]);
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
