package offer.stack;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：用一个栈来保存数据，一个栈来保存最小值。栈顶元素即为当前数据中的最小值
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 注意栈为空的时候，minStack直接进栈
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import java.util.Stack;
public class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : minStack.peek() > node ? node : minStack.peek());
}

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
