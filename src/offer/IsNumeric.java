package offer;


import java.util.Date;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 ````````````````````````````````````例子`````````````````````````````````````
  true

 "+100"
 "5e2"
 "-123"
 "3.1416"
 "-1E-16"
 "-.123"


 false

 "12e"
 "1a3.14"
 "1.2.3"
 "+-5"
 "12e+4.3"
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：
 1.如果有小数点小数点肯定在e的前面。所以小数点的判断在e前面
 2.小数点后面肯定有无符号整数
 3.e后面肯定有有符号整数

 ````````````````````````````````````思考`````````````````````````````````````

 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class IsNumeric {

    private int index = 0;
    public boolean isNumeric(char[] str) {
        int len = str.length;
        boolean flag = scanInteger(str,index);

        if(index < len && str[index] == '.'){
            index++;
            flag = scanUnsignInteger(str,index) || flag;
        }

        if(index < len && (str[index] == 'e' || str[index] == 'E')){
            index++;
            flag = flag && scanInteger(str,index);
        }
        return flag && index == len;
    }


    public boolean scanInteger(char[] str, int start){
        if(index < str.length && (str[index] == '+' || str[index] == '-'))index++;
        return scanUnsignInteger(str,index);
    }


    public boolean scanUnsignInteger(char[] str, int start){
        while (index < str.length && str[index] >= '0' && str[index] <= '9') index++;
        return start < index;
    }


    public static void main(String[] args){
        IsNumeric isNumeric = new IsNumeric();
//        String[] strs = new String[]{ "12e","1a3.14","1.2.3","+-5","12e+4.3"};
//        String[] strs1 = new String[]{"+100","5e2","-123","3.1416","-1E-16"};
//        for (String s : strs){
//            System.out.println(isNumeric.isNumeric(s.toCharArray()));
//            isNumeric.index = 0;
//        }
//
//        for (String s : strs1){
//            System.out.println(isNumeric.isNumeric(s.toCharArray()));
//            isNumeric.index = 0;
//        }


        System.out.println(isNumeric.isNumeric("123.45e+6".toCharArray()));
    }
}
