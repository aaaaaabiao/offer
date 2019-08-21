package leetcode.Array;

/**
 * 翻转句子
 *
 * @author hubiao
 */
public class ReverseSentence {
    public static String reverseSentence(String str){
        if (str == null || str.length() == 0 || str.length() == 1){
            return str;
        }

        char[] arr = str.toCharArray();
        int len = arr.length;
        int p = 0;
        while (p < len){
            while (p < len && arr[p] == ' '){
                p++;
            }
            int e = p;
            while (p < len && arr[p] != ' '){
                p++;
            }
            reverse(arr, e, p-1);
        }
        reverse(arr, 0, len-1);
        return new String(arr);
    }
    private static void reverse(char[] arr, int i, int j){
        int p = i;
        int q = j;
        while (p < q){
            char tmp = arr[p];
            arr[p] = arr[q];
            arr[q] = tmp;

            p++;
            q--;
        }
    }

    public static void main(String[] args){
        String str = "I love you";
        System.out.println(reverseSentence(str));
    }
}



