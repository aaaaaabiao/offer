package offer;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @version: V1.0
 * @author: abiao
 * @className: FirstAppearingOnce
 * @packageName: offer
 * @description: 字符流中第一个不重复的字符
 * @data: 2019/1/7
 **/
public class FirstAppearingOnce {

    private LinkedHashMap<Character,Boolean> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void insert(char ch) {
        if (map.keySet().contains(ch)){
            if (map.get(ch)){
                map.put(ch,false);
            }
        }else {
            map.put(ch,true);
        }
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        for (Map.Entry<Character,Boolean> entry : map.entrySet()){
            if (entry.getValue()){
                return entry.getKey();
            }
        }
        return '#';
    }

    public static void main(String[] args){
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        firstAppearingOnce.insert('g');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('o');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('o');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('g');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('l');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('e');
        System.out.println(firstAppearingOnce.firstAppearingOnce());

    }
}
