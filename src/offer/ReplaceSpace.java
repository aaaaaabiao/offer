package offer;


/*请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* 思路：
* 1.计算出扩字符串扩容成多大
* 2.然后从后往前遍历，将字符一次性移到指定位置。
* */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int count = 0;
        int len = str.length();
        for (int i = 0; i < len; i++){
            if (' ' == str.charAt(i)){
                count++;
            }
        }
        str.setLength(len+2*count);
        int j = str.length()-1;
        for (int i = len-1; i >= 0; i--){
            char ch = str.charAt(i);
            if (ch == ' '){
                str.setCharAt(j,'0');
                j--;
                str.setCharAt(j,'2');
                j--;
                str.setCharAt(j,'%');
                j--;
            }else {
                str.setCharAt(j,ch);
                j--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args){
        StringBuffer buffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(buffer));
    }
}
