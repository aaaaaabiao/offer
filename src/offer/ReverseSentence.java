package offer;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 例如，“student. a am I”。
 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：s代表字符串开始的位置（p后第一个不为空的字符）。用指针p的遍历字符串。每次碰到" "。[s,p-1]代表完整的字符。
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/6
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class ReverseSentence {

    public static String reverseSentence(String str) {
        if (str == null || str.length() == 0) return str;
        char[] arr = str.toCharArray();
        int p = 0;
        int len = arr.length;
        while(p < len){
            while(p < len && arr[p] == ' ') p++;
            int s = p;
            while(p < len && arr[p] != ' ') p++;
            reverseStr(arr,s,p-1);
        }
        reverseStr(arr,0,len-1);
        return new String(arr);
    }

    public static void reverseStr(char[] arr,int start,int end){
        while (start < end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
    
    




    public static void main(String[] args){
        System.out.println(reverseSentence("student. a am I"));
        System.out.println(reverseSentence("student"));
    }
}
