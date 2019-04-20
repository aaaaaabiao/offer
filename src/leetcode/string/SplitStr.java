package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class SplitStr {
    public static List<String> splitedStr(String str, String spliter){
        List<String> ret = new ArrayList<>();

        if(str == null || str.length() == 0 || spliter == null) return ret;
        if(spliter.length() == 0){
            ret.add(str);
            return ret;
        }
        char[] arr1 = str.toCharArray();
        char[] arr2 = spliter.toCharArray();
        int l1 = arr1.length;
        int l2 = arr2.length;
        int p = 0;
        int s = 0;
        int e = 0;
        while (p < l1){
            if(arr1[p] == arr2[0]){
                int i = p+1;
                int j = 1;
                while (i < l1 && j < l2 && arr1[i] == arr2[j]){
                    i++;
                    j++;
                }
                if(j == l2){
                    if(s < p) ret.add(str.substring(s,p));
                    p = i;
                    s = p;
                }else{
                    p++;
                }
            }else{
                p++;
                e = p;
            }
        }
        if(s < l1) ret.add(str.substring(s,l1));
        return ret;
    }

    public static void main(String[] args){
        List<String> ret = splitedStr("88111188222222288833333388","88");
        int a;
    }
}
