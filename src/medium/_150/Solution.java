package medium._150;

import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/01
 *     desc   : 根据逆波兰表示法，求表达式的值。
 *     有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *     说明：整数除法只保留整数部分。给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * </pre>
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * 输入: ["2", "1", "+", "3", "*"]
     * 输出: 9
     * 解释: ((2 + 1) * 3) = 9
     * <p>
     * 输入: ["4", "13", "5", "/", "+"]
     * 输出: 6
     * 解释: (4 + (13 / 5)) = 6
     * <p>
     * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
     * 输出: 22
     * 解释:
     * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int last = stack.pop();
                int first = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(first + last);
                        break;
                    case "-":
                        stack.push(first - last);
                        break;
                    case "*":
                        stack.push(first * last);
                        break;
                    case "/":
                        stack.push(first / last);
                        break;
                    default:
                        break;
                }

            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
