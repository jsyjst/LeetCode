package easy._155;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/01
 *     desc   : 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *     push(x) -- 将元素 x 推入栈中。
 *     pop() -- 删除栈顶的元素。
 *     top() -- 获取栈顶元素。
 *     getMin() -- 检索栈中的最小元素。
 * </pre>
 */
public class MinStack {
    /**
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    private Stack<Integer> res;
    private Stack<Integer> helper;
    public MinStack() {
        res = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        res.push(x);
        if(helper.isEmpty()||helper.peek()>x){
            helper.push(x);
        }else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        res.pop();
        helper.pop();
    }

    public int top() {
       return res.peek();
    }

    public int getMin() {
       return helper.peek();
    }
}
