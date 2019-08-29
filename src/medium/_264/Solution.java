package medium._264;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/29
 *     desc   : 编写一个程序，找出第 n 个丑数。丑数就是只包含质因数 2, 3, 5 的正整数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * <p>
     * 说明:
     * 1 是丑数。
     * n 不超过1690。
     */

    //三指针+动态规划
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;//三指针
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i5] * 5, dp[i3] * 3));
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            dp[i] = min;
        }
        return dp[n - 1];
    }
}
