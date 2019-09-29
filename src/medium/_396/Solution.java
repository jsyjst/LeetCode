package medium._396;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/29
 *     desc   : 给定一个长度为 n 的整数数组 A 。假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
 *     F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 *     计算F(0), F(1), ..., F(n-1)中的最大值。
 * </pre>
 */
public class Solution {
    /**
     * A = [4, 3, 2, 6]
     *
     * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
     * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
     * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
     * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
     * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
     */

    //暴力
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        if(len == 0) return 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum +=j*A[(i+j)%len];
            }
            res = Math.max(sum,res);
        }
        return res;
    }

    //优化，最优解,
    public int maxRotateFunctionBest(int[] A) {
        int len = A.length;
        if(len == 0) return 0;
        int total = 0;
        int[] dp = new int[len];
        for(int i=0;i<len;i++){
            total+=A[i];
            dp[0]+=A[i]*i;
        }
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1]+total-len*A[len-i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
