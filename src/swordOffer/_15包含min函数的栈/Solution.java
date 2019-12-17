package swordOffer._15包含min函数的栈;

import java.util.Stack;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/17
 *     desc   : 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * </pre>
 */
public class Solution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else{
            minStack.push(Math.min(node,minStack.peek()));
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
