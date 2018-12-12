package offer;


import java.util.Queue;
import java.util.Stack;

/**
 * @version: V1.0
 * @author: abiao
 * @className: MyStack
 * @packageName: offer
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @data: 2018/12/12
 **/
public class MyStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
        min = Math.min(min,node);
    }

    public void pop() {
        int value = stack1.pop();
        if (value > min) return;

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        min = Integer.MAX_VALUE;
        while (!stack2.isEmpty()){
            int node = stack2.pop();
            stack1.push(node);
            min = Math.min(min,node);
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return min;
    }
}
