package offer;

public class StrToInt {
    public static int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int len = str.length();
        char first = str.charAt(0);
        int res  = 0;
        if (first == '+' || first == '-'){
            if (len > 1){
                for (int i = 1; i < len; i++){
                    char ch = str.charAt(i);
                    int val = ch - '0';
                    if (val >= 0 && val <= 9){
                        res = res * 10+val;
                    }else {
                        return 0;
                    }
                }
                return first == '+'?res:-res;
            }else {
                return 0;
            }
        }else if ((first-'0' >= 0) && (first-'0'<= 9)){
            for (int i = 0; i < len; i++){
                char ch = str.charAt(i);
                int val = ch - '0';
                if (val >= 0 && val <= 9){
                    res = res * 10+val;
                }else {
                    return 0;
                }
            }
            return res;
        }else {
            return 0;
        }
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
