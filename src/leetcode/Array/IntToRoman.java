package leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class IntToRoman {
////    int[] data = new int[]{1,5,10,50,100,500,1000};
////    char[] chs = new char[]{'I','V','X','L','C','D','M'};
//    public String intToRoman(int num) {
//        String ret = "";
//        int n = 0;
//        while(num != 0){
//            int p = num % 10;
//            if (p == 0){
//                ret = core(num*(int)Math.pow(10.0,n))+ret;
//                break;
//            }
//            ret = core(p*(int)Math.pow(10.0,n))+ret;
//            n++;
//            num = num / 10;
//        }
//        return ret;
//    }
//
//
//    public String core(int num){
//        for(int i = 0; i < data.length; i++){
//            if(num / data[i] == 0){
//                int p = num / data[i];
//                String str = "";
//                if(p % 4 || p == 9){
//                    str = "I"+ chs[i];
//                }else{
//                    int q = num % data[i-1];
//                    str = q == 0 ? "" : chs[i-1]+"";
//                    if(q == 0){
//                        while(num-- > 0) str += chs[0];
//                    }else{
//                        while(q-- > 0) str += chs[i-2];
//                    }
//                }
//                return str;
//            }
//
//            if(num / data[i] == 1 && num % data[i] == 0){
//                return chs[i]+"";
//            }
//        }
//
//        return "";
//    }
    int[] data = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] chs = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    //罗马数组转整数
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int p = 0;
        int q = 0;
        int res = 0;
        int len = arr.length;
        while(p < len){
            if(s.substring(p,p+1).equals(chs[q])){
                res += data[q];
                p++;
             }else if(p+1 < len && s.substring(p,p+2).equals(chs[q])){
                res += data[q];
                p += 2;
            }else{
                q++;
            }
        }

        return res;
    }

    //整数转罗马数字
    public String intToRoman(int num) {
        int[] data = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] chs = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder ret = new StringBuilder();
        int p = 0;
        int len = chs.length;
        while(num != 0 && p < len){
            if(num - data[p] >= 0){
                num -= data[p];
                ret.append(chs[p]);
            }else{
                p++;
            }
        }

        return ret.toString();
    }
    public static void main(String[] args){
        IntToRoman ir = new IntToRoman();
        System.out.println(ir.romanToInt("DCXXI"));
        HashMap<Character,Character> map = new HashMap();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        System.out.println(map.get('('));
    }
}
