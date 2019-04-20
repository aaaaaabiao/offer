package offer;


import java.util.Stack;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 ````````````````````````````````````例子`````````````````````````````````````
 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 ````````````````````````````````````链接`````````````````````````````````````
 https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2030~39.md#30-%E5%8C%85%E5%90%AB-min-%E5%87%BD%E6%95%B0%E7%9A%84%E6%A0%88
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：用一个栈来模拟进栈，出栈顺序。
 描述：首先按进栈序列进栈。进完栈后，判断栈顶元素是否和出栈序列一样。一直出栈知道不一样。最后看栈是不是为空
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class IsPopOrder {
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        int len = popA.length;
        if (len == 0) return true;
        if (len == 1){
            if (pushA[0] == popA[0]){
                return true;
            } else {
                return false;
            }
        }
        int value = popA[0];
        int pos = 0;
        for (int i = 0; i < len; i++){
            if (value == pushA[i]){
                pos = i;
                break;
            }
        }
        int p = 1;
        for (int i = pos-1; i >=0;){
            int last = pushA[i];
            if (popA[p] != last) {
                for (int q = i-1; q >= 0; q--){
                    if (popA[p] == pushA[q]) return false;
                }
            }else{
                i--;
            }
            p++;
        }
        return true;
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack();
        int p = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while (p < popA.length && !stack.isEmpty() && stack.peek() == popA[p]){
                stack.pop();
                p++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        int[] pop1 = {4,3,5,1,2};
        System.out.println(IsPopOrder(push,pop));
        System.out.println(isPopOrder(push,pop1));
    }
}
