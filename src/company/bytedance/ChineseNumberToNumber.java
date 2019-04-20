package company.bytedance;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 将中文数字转换为阿拉伯数字
 ````````````````````````````````````例子`````````````````````````````````````
 九千八百五十七========9857
 三万九千八百五十七====39857

 九千七百零六万五百零一=====97060501
 ````````````````````````````````````链接`````````````````````````````````````

 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：
 数字映射：零-九映射为0-9
 单位映射：十-亿映射为10-100000000

 中文数字的特点是一个数字接一个单位

 对于单位为万以下的：这个数字的范围为[0,9]。
 比如：一千五百九十六

 对于单位为万：这个数字的[0,9999]。
 同理，亿也是一样。

 从左往右遍历。
 用number表示单位前的数字
 用section来记录万以下的数字。

 1.是数字用number记录下来。
 2.下一个肯定是单位。
 3.拿数字和单位相乘得到值。累计到section中。万的时候将section的变为0
 ````````````````````````````````````思考`````````````````````````````````````

 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/20
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import java.util.HashMap;
import java.util.Map;

public class ChineseNumberToNumber {

    private Map<Character,Integer> m1 = new HashMap<>();
    private Map<Character,Integer> m2 = new HashMap<>();

    {
        m1.put('零',0);
        m1.put('一',1);
        m1.put('二',2);
        m1.put('三',3);
        m1.put('四',4);
        m1.put('五',5);
        m1.put('六',6);
        m1.put('七',7);
        m1.put('八',8);
        m1.put('九',9);

        m2.put('十',10);
        m2.put('百',100);
        m2.put('千',1000);
        m2.put('万',10000);
        m2.put('亿',100000000);

    }
    public int change(String nums){
        char[] chars = nums.toCharArray();

        int number = 0;
        int ret = 0;
        int section = 0;
        for (int i = 0; i < chars.length; i++){
            char n = chars[i];
            if (m1.containsKey(n)){
                number = m1.get(n);
                if(i == chars.length - 1) section += number;
            }else if (m2.containsKey(n)){
                int unit = m2.get(n);
                if(n == '万' || n == '亿'){
                    section = (section+number) * unit;
                    ret += section;
                    section = 0;
                }else{
                    section += (number * unit);
                }
                number = 0;
            }

        }
        return ret+section;
    }


    public static void main(String[] args){
        ChineseNumberToNumber cntn = new ChineseNumberToNumber();
        String[] strs = new String[]{"三万九千八百五十七","九千七百零六万五百零一"};
        for (String s : strs){
            System.out.println(cntn.change(s));
        }
    }
}
