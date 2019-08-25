package offer.backtracing;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 ````````````````````````````````````例子`````````````````````````````````````
 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：全排列，采用回溯法，注意去重
 描述：想象成一课递归树，递归树有两种放回方式：
        1.全部排完了s.length() == len。
        2.下面的循环结束了。
 去重操作就是：str.charAt(i) == str.charAt(i-1) && !visit[i-1]。意思是以前一节点为头所有情况已经算完了。再以当前节点算都是重复的。
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Permutation {


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
        String str = "a";
//        ArrayList ret = permutation(str);
        ArrayList ret1 = permutation1(str);
        int a = 0;
    }
}
