package offer;


/**
 ``````````````````````````````````题目描述```````````````````````````````````
 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 ````````````````````````````````````例子`````````````````````````````````````
 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：用一个队列和一个map数组来实现。
 描述：队列的队头元素代表不重复的数字。
 为什么用队列呢？
 队列FIFO，正好符合了第一次出现这个概念。abcd流第一次出现为a。abcda。第一次出现为b。
 如何维护这个队列呢？
 首先用一个数组来记录。某个元素是不是已经存在出现过了。
 当某个元素出现过的时候。则需要把对头元素出队。直到出队到对头元素没有出现过。
 ````````````````````````````````````思考`````````````````````````````````````

 因为元素是字符的。所以可以创建一个大小为256的数组，来做元素是否出现过的映射关系。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstAppearingOnce {


    public class Solution {
        Queue<Character> queue = new LinkedList();
        int[] chs = new int[256];
        //Insert one char from stringstream
        public void Insert(char ch)
        {
            chs[ch]++;
            queue.add(ch);
            while(!queue.isEmpty() && chs[queue.peek()] > 1){
                queue.poll();
            }
        }
        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce()
        {
            return queue.isEmpty() ? '#' : queue.peek();
        }
    }

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
