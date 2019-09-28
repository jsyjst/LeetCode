package medium._394;

import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/28
 *     desc   : 给定一个经过编码的字符串，返回它解码后的字符串。
 *     编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *     你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *     此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入
 * </pre>
 */
public class Solution {
    /**
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(char c:s.toCharArray()){
            String cString = String.valueOf(c);
            if(c!=']'){
                stack.push(cString);
            }else {
                StringBuilder beforeRepeatString = new StringBuilder();
                StringBuilder afterRepeatString = new StringBuilder();
                while (!stack.peek().equals("[")){
                    beforeRepeatString.append(stack.pop());
                }
                stack.pop();//pop掉[
                //得到重复次数,有可能是多位数
                StringBuilder  repeat = new StringBuilder();
                while (!stack.isEmpty()&&stack.peek().charAt(0)>='0'&&stack.peek().charAt(0)<='9'){
                    repeat.append(stack.pop());
                }
                int repeatInt  = Integer.valueOf(repeat.reverse().toString());
                for (int i = 0; i < repeatInt; i++) {
                    afterRepeatString.append(beforeRepeatString);
                }
                stack.push(afterRepeatString.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
