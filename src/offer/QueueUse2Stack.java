package offer;

import java.util.Stack;

/**
 * @version: V1.0
 * @author: abiao
 * @className: QueueUse2Stack
 * @packageName: offer
 * @description: 用两个栈来实现队列。思考问题的2个方面（1.出队,2.队空判断）
 * @data: 2018/11/21
 **/
public class QueueUse2Stack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop(){
        if (stack2.isEmpty()){
            if (stack1.isEmpty()) throw new RuntimeException("栈空,无法出栈！");
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static void main(String[] args){
        QueueUse2Stack queueUse2Stack = new QueueUse2Stack();
        queueUse2Stack.push(1);
        queueUse2Stack.push(2);
        queueUse2Stack.push(3);
        queueUse2Stack.push(4);
        queueUse2Stack.push(5);

        for (int i = 0; i < 5; i++){
            System.out.println(queueUse2Stack.pop());
        }
    }
}
