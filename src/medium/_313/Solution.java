package medium._313;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/08
 *     desc   : 编写一段程序来查找第 n 个超级丑数。超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: n = 12, primes = [2,7,13,19]
     * 输出: 32
     * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] indexs = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(primes[j]*dp[indexs[j]],min);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if(min == dp[indexs[j]] * primes[j]) indexs[j]++;
            }
        }
        return dp[n-1];
    }
}
