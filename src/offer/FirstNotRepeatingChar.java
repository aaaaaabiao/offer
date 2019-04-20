package offer;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：用一个数组来记录字符串出现的次数，然后遍历字符串。找到一个第一个出现次数为1的字符。
 ````````````````````````````````````思考`````````````````````````````````````
 优化：可以使用2个256大小的bitset。来代表字符串出现的次数
 0,0代表没有出现
 0,1代表出现1次
 1,1代表出现多次
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/

import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch,-1);
            }else {
                map.put(ch,i);
            }
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            Character key = entry.getKey();
            int value = entry.getValue();
            if (value != -1){
                return value;
            }
        }

        return -1;
    }


    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
                bs1.set(c);     // 0 0 -> 0,1
            else if (bs1.get(c) && !bs2.get(c))
                bs2.set(c);     // 0 1 -> 1 1
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))  // 0 1
                return i;
        }
        return -1;
    }

    public static void main(String[] args){
        String str = "abcabcd";
        System.out.println(firstNotRepeatingChar(str));
    }
}
