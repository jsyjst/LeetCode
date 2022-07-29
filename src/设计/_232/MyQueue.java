package 设计._232;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/21
 *     desc   : 使用栈实现队列的下列操作：
 *     push(x) -- 将一个元素放入队列的尾部。
 *     pop() -- 从队列首部移除元素。
 *     peek() -- 返回队列首部的元素。
 *     empty() -- 返回队列是否为空。
 * </pre>
 */
public class MyQueue {
    /**
     * MyQueue queue = new MyQueue();
     *
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     */
    /**
     * Initialize your data structure here.
     */
    private Stack<Integer> stackIn;  //输入栈
    private Stack<Integer> stackOut; //输出栈
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()) stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()) stackOut.push(stackIn.pop());
        }
        return stackOut.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
       return stackOut.isEmpty()&&stackIn.isEmpty();
    }
}
