package medium._343;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/18
 *     desc   : 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 * </pre>
 */
public class Solution {
    /**
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * <p>
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * <p>
     * 说明: 你可以假设 n 不小于 2 且不大于 58
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = i - 2; j >= 2; j--) {
                dp[i] =Math.max(dp[i],Math.max(dp[j], j) * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
}
