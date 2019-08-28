package easy._258;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/28
 *     desc   : 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     *
     * 进阶:
     * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
     */
    public int addDigits(int num) {
        int sum = 0;
        while (num!=0){
            sum += num%10;
            num/=10;
        }
        int res = sum%10+sum/10;
        return res>=10?res%10+1:res;
    }
}
