package medium._227;

import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/22
 *     desc   : 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *     字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分
 * </pre>
 */
public class Solution {
    /**
     * 输入: "3+2*2"
     * 输出: 7
     *
     * 输入: " 3/2 "
     * 输出: 1
     *
     * 输入: " 3+5 / 2 "
     * 输出: 5
     *
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     */
    public int calculate(String s) {
        int res = 0;
        int d = 0; //用来存储当前的数字，d有可能大于10
        char sign = '+';//用来存储上一个符号
        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<>();//用来存储整数，包括乘除后的整数
        for (int i = 0; i < c.length; i++) {
            if(c[i]>='0'){  //加减乘除，空格ascii码都小于‘0’
                d = d*10+c[i]-'0';
            }
            if(c[i]<'0'&&c[i]!=' '|| i==c.length-1){
                if(sign == '+'){
                    stack.push(d);
                }else if(sign == '-'){
                    stack.push(-d);
                }else{
                    int temp = sign =='*'?stack.pop()*d:stack.pop()/d;
                    stack.push(temp);
                }
                sign = c[i];  //保存当前符号
                d = 0;  //置为0
            }
        }
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
