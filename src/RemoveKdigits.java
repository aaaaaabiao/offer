

/*
* 给定一个整数，从整数中去掉k个数字，使剩下的整数最小
* 思路：从高位到低位，如果高位大于相邻低位，去掉高位
*
* */
public class RemoveKdigits {
    public static String removeKdigits(String num, int k){
        int newLength = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        int i = 0;
        for (char ch : num.toCharArray()){
            while (top > 0 && stack[top-1] > ch && k > 0){
                top--;
                k--;
            }
            stack[top++] = ch;
        }

        int offset = 0;
        while (offset < newLength && stack[offset] == '0'){
            offset++;
        }

        return offset == newLength ? "0" : new String(stack,offset,newLength-offset);
    }

    public static void main(String[] args){
        //System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
    }
}
