import java.util.Arrays;


/*
*求字符串数组的最长公共前缀
* 基本思想：
* 先将strs排序。然后找到第一和最后一个字符串的公共前缀。就是整个字符串数组的前缀
* */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer str = new StringBuffer();
        if (strs.length > 0 && strs != null){
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length-1].toCharArray();

            for (int i = 0; i < a.length; i++){
                if (a[i] == b[i]){
                    str.append(a[i]);
                }else {
                    return str.toString();
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args){
        System.out.println(longestCommonPrefix(new String[]{"abc","abcd","abcf"}));
    }
}
