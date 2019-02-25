package offer;

import java.util.Stack;
/**
 * @version: V1.0
 * @author: abiao
 * @className: MinStack
 * @packageName: offer
 * @description: 以O(1)的时间负责度得到栈中最小的元素
 * @data: 2019/2/25
 **/
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
