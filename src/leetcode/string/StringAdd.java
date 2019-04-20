package leetcode.string;

/**
 * Created by 73681 on 2019/3/6.
 */
public class StringAdd {

    public static String multiply(String num1, String num2) {

        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)return "";

        if (num1.equals("0") || num2.equals("0")) return "0";
        String ret = "0";
        StringBuffer buffer = new StringBuffer();
        for (int i = num2.length()-1; i >= 0; i--){
            if (num2.charAt(i) == '0') continue;
            //乘单个数
            String s = "0";
            for (int n = 0; n < num2.charAt(i)-'0';n++){
                s = add(s,num1);
            }
            for (int p = num2.length()-1;p > i;p--){
                s += "0";
            }
            ret = add(ret,s);
        }

        return ret;
    }

    public static String add(String s1, String s2){
        int p = s1.length()-1;
        int q = s2.length()-1;
        int n = 0;
        String str = "";
        while(p >= 0 && q >= 0){
            int a = s1.charAt(p) - '0';
            int b = s2.charAt(q) - '0';

            int val = n+a+b;
            if(val >= 10){
                val = val -10;
                n = 1;
            }else{
                n = 0;
            }
            str = val + str;
            q--;
            p--;
        }

        if(p >= 0){
            if(n == 0){
                str = s1.substring(0,p+1)+str;
            }else{
                str = add(s1.substring(0,p+1),"1")+str;
            }
        }else if(q >= 0){
            if(n == 0){
                str = s2.substring(0,q+1)+str;
            }else{
                str = add(s2.substring(0,q+1),"1")+str;
            }
        }else{
            if(n == 1){
                str = "1"+str;
            }
        }

        return str;
    }


    public static void main(String[] args){
        System.out.println(add("15","2"));
        System.out.println(multiply("123","456"));
    }
}
