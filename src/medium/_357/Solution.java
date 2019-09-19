package medium._357;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/19
 *     desc   : 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 2
     * 输出: 91
     * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
     */

    //排列组合递归解决
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n == 1) return 10;
        if(n == 2) return 91;
        if(n>10) return 0;
        int res = 9;
        int count = 1;
        for (int i = 9; count<=n-1; i--) {
            res*=i;
            count++;
        }
        return res+countNumbersWithUniqueDigits(n-1);
    }

    //动态规划
    public int countNumbersWithUniqueDigitsByDb(int n) {
        if(n==0) return 1;
        if(n == 1) return 10;
        if(n == 2) return 91;
        if(n>10) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+(dp[i-1]-dp[i-2])*(10-(i-1));
        }
        return dp[n];
    }
}
