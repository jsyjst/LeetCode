package medium._402;

import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/10
 *     desc   : 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * </pre>
 */
public class Solution {
    /**
     * 输入: num = "1432219", k = 3
     * 输出: "1219"
     * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
     *
     * 输入: num = "10200", k = 1
     * 输出: "200"
     * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
     *
     * 输入: num = "10", k = 2
     * 输出: "0"
     * 解释: 从原数字移除所有的数字，剩余为空就是0。
     */
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(num.length() == k) return "0";
        StringBuilder builder = new StringBuilder(num);
        //k次扫描
        for (int i = 0; i < k; i++) {
            int index = 0;
            for (int j = 1; j < builder.length(); j++) {
                if(builder.charAt(j)>=builder.charAt(j-1)){
                    index = j;
                }else {
                    break;
                }
            }
            builder.delete(index,index+1);
            while (builder.length()>1&&builder.charAt(0)=='0') builder.delete(0,1);
        }
        return builder.toString();
    }

    //单调栈实现
    public String removeKdigitsStack(String num, int k) {
        if(k == 0) return num;
        if(num.length() == k) return "0";
        Stack<Integer> stack = new Stack<>();
        stack.push(num.charAt(0)-'0');
        for (int i = 1; i < num.length(); i++) {
            int now = num.charAt(i)-'0';
            while (!stack.isEmpty()&&stack.peek()>now&&k>0){
                stack.pop();
                k--;
            }
            //有可能最后是0,但是栈已经空了，这时候还是得把0添加到栈里面
            if(now!=0||stack.isEmpty()){
                stack.push(now);
            }
        }
        //有可能出现这种情况2345，就直接pop
        while (k>0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        //逆序输出
        return res.reverse().toString();
    }
}
