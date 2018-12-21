package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: FirstNotRepeatingChar
 * @packageName: offer
 * @description: 第一个只出现一次的字符
 * @data: 2018/12/20
 **/

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

    public static void main(String[] args){
        String str = "abcabcd";
        System.out.println(firstNotRepeatingChar(str));
    }
}
