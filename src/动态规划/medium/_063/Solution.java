package 动态规划.medium._063;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/13
 *     desc   : 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *     现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *     网格中的障碍物和空位置分别用 1 和 0 来表示。
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        int[][] nums = {
                {0,1}
        };
        System.out.println(uniquePathsWithObstaclesBetter(nums));
    }
    /**
     * 示例 1:
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     *
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n= obstacleGrid.length;
        int m= obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1] == 1||obstacleGrid[0][0] == 1) return 0;
        int[][] paths = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(obstacleGrid[i][j] ==1){
                    paths[i][j] = 0;
                }else if(i == 0 || j==0){
                    if(j!=0&&paths[i][j-1] == 0){
                        paths[i][j] = 0;
                    }else if (i!=0&&paths[i-1][j] ==0){
                        paths[i][j] = 0;
                    }else {
                        paths[i][j] = 1;
                    }
                }else {
                    paths[i][j] = paths[i-1][j]+paths[i][j-1];
                }
            }
        }
        return paths[n-1][m-1];
    }

    public static int uniquePathsWithObstaclesBetter(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        if(obstacleGrid[0][0] == 1) return 0;
        for(int i = 0; i < n; i++)
            if(obstacleGrid[0][i] == 0)
                dp[i] = 1;
            else
                break;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else if(j != 0)  {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}
