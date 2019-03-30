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
import java.util.Arrays;
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


    public static ArrayList<String> permutation1(String str) {
        ArrayList ret = new ArrayList();
        if(str == null || str.length() == 0) return ret;
        StringBuffer buffer = new StringBuffer();
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        boolean[] visit = new boolean[str.length()];
        backtracing(ret,visit,buffer,new String(chs));
        return ret;

    }

    public static void backtracing(ArrayList<String> ret, boolean[] visit,StringBuffer s,String str){
        int len = str.length();
        if(s.length() == len){
            ret.add(s.toString());
            return;
        }

        for(int i = 0; i < len; i++){
            if(visit[i]) continue;
            if(i > 0 && str.charAt(i) == str.charAt(i-1) && !visit[i-1]) continue;
            s.append(str.charAt(i));
            visit[i] = true;
            backtracing(ret,visit,s,str);
            visit[i] = false;
            s.deleteCharAt(s.length()-1);
        }
    }


    public static void main(String[] args){
        String str = "a";
//        ArrayList ret = permutation(str);
        ArrayList ret1 = permutation1(str);
        int a = 0;
    }
}
