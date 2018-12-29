package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: ReverseSentence
 * @packageName: offer
 * @description: 翻转单词顺序列
 * @data: 2018/12/29
 **/
public class ReverseSentence {
    public static String reverseSentence(String str) {
        if (str.length() == 0 || str == null) return str;
        char[] arr = str.toCharArray();
        int p = 0;
        int q = 0;
        boolean flag = false;
        for (char ch : arr){
            if (ch == ' '){
                if (p != q){
                    reverseStr(arr,p,q-1);
                    q++;
                    p = q;
                }else {
                    p++;
                    q++;
                }
                flag = true;
            }else {
                q++;
            }
        }


        if (!flag){
            return new String(arr);
        }else {
            if (p != q){
                reverseStr(arr,p,q-1);
            }
            reverseStr(arr,0,arr.length-1);
            return new String(arr);
        }

    }

    public static void reverseStr(char[] arr,int start,int end){
        while (start < end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        System.out.println(reverseSentence("student. a am I"));
        System.out.println(reverseSentence("student"));
    }
}
