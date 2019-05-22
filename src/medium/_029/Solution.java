package medium._029;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/22
 *     desc   : 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *              返回被除数 dividend 除以除数 divisor 得到的商。
 *              说明:
 *              被除数和除数均为 32 位有符号整数。除数不为 0。
 *              假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
 *              本题中，如果除法结果溢出，则返回 231 − 1。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
    /**
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     *
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     */

    /**
     * 核心：位移法：向左移1相当于乘以2，向右位移1相当于除以2
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     */
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int trade=0;
        boolean isPositive = false;
        if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)) isPositive = true;
        long d = (long) dividend;//防止在加绝对值时会出错，比如dividend = Integer.MIN_VALUE时。
        long s = (long) divisor;
        d = Math.abs(d);
        s = Math.abs(s);
        for (int i = 31; i >=0 ; i--) {
            if((d>>i)>= s){
                trade += 1<<i;
                d -= s<<i;
            }
        }
        return isPositive?trade:-trade;
    }
}
