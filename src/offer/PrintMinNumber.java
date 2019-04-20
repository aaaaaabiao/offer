package offer;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 ````````````````````````````````````例子`````````````````````````````````````
 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：按照某种方式排序
 描述：s1,s2,s3,s4。
 为什么s1+s2+s3+s4最小？
 s1+s2 < s2+s1
 s2+s3 < s3+s2
 s1+s3 < s3+s1

 s1+s2+s3 < s2+s1+s3 < s2+s3+s1 < s3+s2+s1
          < s1+s3+s2 < s3+s1+s2
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import javafx.util.converter.NumberStringConverter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintMinNumber {
    public static String printMinNumber(int [] numbers) {
        int len = numbers.length;
        if (len == 0) return "";
        Integer[] integers = new Integer[len];
        for (int i = 0; i < len; i++){
            integers[i] = numbers[i];
        }

        List<Integer> ls = Arrays.asList(integers);
        Collections.sort(ls, (s1,s2) -> (s1+s2+"").compareTo(s2+s1+""));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ls){
            stringBuilder.append(i);
        }
        return stringBuilder.toString();

    }
    public static void main(String[] args){
        int[] numbers = new int[]{3,32,321};
        System.out.println(printMinNumber(numbers));

    }
}
