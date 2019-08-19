package medium._221;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/19
 *     desc   : 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * 输出: 4
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int row = matrix.length;
        int rank = matrix[0].length;
        int[][] dp = new int[row+1][rank+1];
        int maxLen = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= rank; j++) {
                if (matrix[i - 1][j - 1] != '1') {
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                maxLen = Math.max(dp[i][j],maxLen);

            }
        }
        return maxLen*maxLen;
    }
}
