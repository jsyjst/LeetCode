package easy._371;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/20
 *     desc   : 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * </pre>
 */
public class Solution {
    /**
     * 输入: a = 1, b = 2
     * 输出: 3
     *
     * 输入: a = -2, b = 3
     * 输出: 1
     */
    public int getSum(int a, int b) {
        int sum,carry;
        sum = a^b;
        carry = (a&b)<<1;
        if(carry!=0){
            return getSum(sum,carry);
        }
        return sum;
    }
}
