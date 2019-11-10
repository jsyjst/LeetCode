package easy._507;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/10
 *     desc   : 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *     给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 * </pre>
 */
public class Solution {
    /**
     * 输入: 28
     * 输出: True
     * 解释: 28 = 1 + 2 + 4 + 7 + 14
     */
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        int sum = 1;
        for (int i = 2; i <=Math.sqrt(num) ; i++) {
            if(num%i==0) sum+=i+num/i;
        }
        return num==sum;
    }
}
