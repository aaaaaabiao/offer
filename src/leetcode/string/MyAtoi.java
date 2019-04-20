package leetcode.string;

public class MyAtoi {
    public static int myAtoi(String str) {
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
            res = isNegative ? -res:res;
            if(res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(res < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)res;
    }

    public static void main(String[] args){
        myAtoi(" -42");
    }
}
