package leetcode.DFS;

import java.util.*;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典中的单词。
 ````````````````````````````````````例子`````````````````````````````````````
 输入:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]
 输出: 5
 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 返回它的长度 5。


 输入:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 输出: 0

 解释: endWord "cog" 不在字典中，所以无法进行转换。
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/word-ladder/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：DFS广度优先搜索
 描述：采用广度优先搜索，第一次搜索到的endWord的层数就是最短的转换序列的长度。用队列来实现广度优先搜索。
 ````````````````````````````````````思考`````````````````````````````````````
 1.如何记录层数？
 通过在队列中通过插入Null来统计层数。每次碰到一个null代表层数+1。并且在下一层后面加个null。

 2.序列中有重复的元素，需要去重。
 采用的方法是用set去重。

 3.广度优先搜索还需要visit的序列来记录节点是否已经被访问了。题中采用的set集合。可以通过contains函数来判断字符串是否存在。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class LadderLength {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        q.add(null);
        int level = 1;//代表正在操作的是第几层
        HashSet<String> visit = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        visit.add(beginWord);
        while(!q.isEmpty()){
            String str = q.poll();
            if(str != null){
                for(int i = 0; i < str.length(); i++){
                    char[] chs = str.toCharArray();
                    for(char c = 'a' ; c <= 'z'; c++){
                        chs[i] = c;
                        String word = new String(chs);
                        if(endWord.equals(word)) return level+1;
                        if(!visit.contains(word) && set.contains(word)){
                            q.add(word);
                            visit.add(word);
                        }
                    }
                }

            }else{
                level++;
                if(!q.isEmpty()) q.add(null);
            }

        }

        return 0;
    }
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        ladderLength(beginWord,endWord,wordList);

    }
}
