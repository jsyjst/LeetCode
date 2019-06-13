package medium._062;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/13
 *     desc   : 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *     问总共有多少条不同的路径？
 *
 *     说明：m 和 n 的值均不超过 100。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * <p>
     * 示例 2:
     * 输入: m = 7, n = 3
     * 输出: 28
     *
     * 时间复杂度O(m*n)
     * @param m m行
     * @param n m列
     * @return 不同的路径的总和
     */

    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        int[][] paths = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j==0) {
                    paths[i][j] = 1;
                }else {
                    paths[i][j] = paths[i-1][j]+paths[i][j-1];
                }
            }
        }
        return paths[n-1][m-1];
    }

    /**
     * 优化空间复杂度2o(n)
     */
    public int uniquePathsBetter(int m, int n) {
        if (m == 1 && n == 1) return 1;
        int[] current = new int[n];
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            current[i] = 1;
            pre[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                current[j] = pre[j] + current[j-1];
            }
            pre = current.clone();
        }
        return current[n-1];
    }

    /**
     * 优化空间复杂度o(n)
     */
    public int uniquePathsBest(int m, int n) {
        if (m == 1 && n == 1) return 1;
        int[] current = new int[n];
        for (int i = 0; i < n; i++) {
            current[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                current[j]  += current[j-1];
            }
        }
        return current[n-1];
    }

    /**
     * 排列组合解法
     */

}
