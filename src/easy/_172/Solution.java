package easy._172;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/05
 *     desc   : 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     *
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     * 说明: 你算法的时间复杂度应为 O(log n) 。
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n>=5){
            count += n/5;
            n/=5;
        }
        return count;
    }
}
