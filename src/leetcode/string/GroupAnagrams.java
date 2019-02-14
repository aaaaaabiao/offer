package leetcode.string;
import java.util.*;

/**
 * @version: V1.0
 * @author: abiao
 * @className: GroupAnagrams
 * @packageName: leetcode.string
 * @description: https://leetcode.com/problems/group-anagrams/
 * @data: 2019/2/14
 **/
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return res;
        }
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if (map.containsKey(s)){
                 map.get(s).add(str);
            }else {
                List<String> ls = new ArrayList<>();
                ls.add(str);
                map.put(s,ls);
            }
        }
        for (Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List res = groupAnagrams(strs);
    }
}
