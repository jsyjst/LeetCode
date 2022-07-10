package easy._020;

import java.util.HashMap;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/15
 *     desc   : 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *             有效字符串需满足：
 *             左括号必须用相同类型的右括号闭合。
 *             左括号必须以正确的顺序闭合。
 *             注意空字符串可被认为是有效字符串。
 * </pre>
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    /**
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * <p>
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * <p>
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     * <p>
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     */
    public static boolean isValid(String s) {
        //如果字符串的个数是奇数
        if (s.length() % 2 != 0) return false;
        //用map来存储括号匹配
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        //遍历字符串，如果字符和栈顶元素匹配则出栈，否则出栈
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) != map.get(stack.peek())) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    public static boolean isValid2(String s) {
        //如果字符串的个数是奇数
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        //遍历字符串，如果字符和栈顶元素匹配则出栈，否则出栈
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }
}
