package medium._304;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/06
 *     desc   : 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * </pre>
 */
public class NumMatrix {
    /**
     * 给定 matrix = [
     *   [3, 0, 1, 4, 2],
     *   [5, 6, 3, 2, 1],
     *   [1, 2, 0, 1, 5],
     *   [4, 1, 0, 1, 7],
     *   [1, 0, 3, 0, 5]
     * ]
     *
     * sumRegion(2, 1, 4, 3) -> 8
     * sumRegion(1, 1, 2, 2) -> 11
     * sumRegion(1, 2, 2, 4) -> 12
     *
     * 说明:你可以假设矩阵不可变。
     * 会多次调用 sumRegion 方法。
     * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
     */
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if(row == 0) return;
        int col = matrix[0].length;
        dp = new int[row+1][col+1];
        for (int i = 1; i < row+1; i++) {
            for (int j = 1; j < col+1; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]) + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }
}
