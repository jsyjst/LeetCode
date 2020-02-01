package 动态规划.medium._064;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/14
 *     desc   : 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *              说明：每次只能向下或者向右移动一步。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */

    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j==0){
                    res[i][j] = grid[0][0];
                }else if(i == 0){
                    res[i][j] = grid[i][j] + res[i][j-1];
                }else if(j == 0){
                    res[i][j] = grid[i][j] + res[i-1][j];
                }else {
                    res[i][j] = Math.min(res[i-1][j],res[i][j-1])+grid[i][j];
                }
            }
        }
        return res[m-1][n-1];

    }
}
