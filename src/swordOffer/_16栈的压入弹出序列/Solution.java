package swordOffer._16栈的压入弹出序列;

import java.util.Stack;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/17
 *     desc   :
 * </pre>
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 && popA.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                index++;
                stack.pop();
            }
            if (index == popA.length) break;
        }
        return stack.isEmpty();
    }
}
