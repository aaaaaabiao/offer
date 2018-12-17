package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: Permutation
 * @packageName: offer
 * @description: 求字符串的全排列
 * @data: 2018/12/17
 **/

import java.util.ArrayList;
import java.util.TreeSet;

public class Permutation {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();

        if (str.length() == 0) return ret;
        //递归基
        if (str.length() == 1) {
            ret.add(str);
            return ret;
        }
        //递归的求[1,len-1]所组成的全排列
        ArrayList<String> ls = permutation(str.substring(1,str.length()));
        char ch = str.charAt(0);
        //利用set来进行去重操作
        TreeSet<String> set =  new TreeSet();
        for (String s : ls){
            int len = s.length();
            String tmp = null;
            for (int i = 0; i <= len; i++){
                String newStr = s.substring(0,i) + ch + s.substring(i,len);
                //重复的字符不加如答案中
                set.add(newStr);
            }
        }
        ret.addAll(set);
        return ret;
    }


    public static void main(String[] args){
        String str = "aba";
        ArrayList ret = permutation(str);

        int a = 0;
    }
}
