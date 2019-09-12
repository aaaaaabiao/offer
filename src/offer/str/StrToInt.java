package offer.str;
/**
 * @version: V1.0
 * @author: abiao
 * @className: StrToInt
 * @packageName: offer
 * @description: 把字符串转为整数，转成int型可能会出现越界的问题，所以考虑用long来保存结果。
 * @data: 2019/1/3
 **/
public class StrToInt {
    public static int strToInt(String str) {
        if(str == null || str.length() == 0) return 0;
        char[] chs = str.toCharArray();
        int pos = 0;
        int len = str.length();
        while(pos < len && chs[pos] == ' ') pos++;
        if(pos >= len || (chs[pos] != '+' && (chs[pos] < '0' || chs[pos] > '9') && chs[pos] != '-')) return 0;
        boolean isNegative = (chs[pos] == '-');
        long res = 0;
        if(chs[pos] == '-' || chs[pos] == '+') pos++;
        if(pos < len && (chs[pos] < '0' || chs[pos] > '9')) return 0;
        while(pos < len && chs[pos] >= '0' && chs[pos] <= '9'){
            res = res*10 + (chs[pos]-'0');
            pos++;
            long r = isNegative ? -res:res;
            if(r > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(r < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return isNegative ? -(int)res:(int)res;
    }

    public static void main(String[] args){
        System.out.println(strToInt("432432"));
        System.out.println(strToInt("-432432"));
        System.out.println(strToInt("4324b32"));
        System.out.println(strToInt("-a432432"));
        System.out.println(strToInt("-"));
        System.out.println(strToInt("-1"));
    }
}
