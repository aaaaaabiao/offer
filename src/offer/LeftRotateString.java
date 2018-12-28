package offer;

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

    public static void main(String[] args){
        System.out.println(leftRotateString("abcXYZdef",3));
    }
}
