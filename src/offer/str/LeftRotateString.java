package offer.str;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @version: V1.0
 * @author: abiao
 * @className: LeftRotateString
 * @packageName: offer
 * @description: 循环左移（还可以采用三次翻转操作）
 * @data: 2018/12/28
 **/
public class LeftRotateString {
    public static String leftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0 || str == null) return str;
        int pos = n % len;
        String s1  = str.substring(0,pos);
        String s2 = str.substring(pos,len);
        return s2+s1;
    }


    public static String leftRotateStringV1(String str, int n) {
        int len = str.length();
        if (len == 0 || str == null) return str;
        int pos = n % len;
        char[] chs = str.toCharArray();
        reverse(chs, 0, pos-1);
        reverse(chs, pos, len - 1);
        reverse(chs, 0, len - 1);
        return new String(chs);
    }

    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        System.out.println(leftRotateString("abcXYZdef",3));
        System.out.println(leftRotateStringV1("abcXYZdef",3));
    }
}
