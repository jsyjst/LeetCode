package 动态规划.medium._120;

import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/21
 *     desc   : 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * </pre>
 */
public class Solution {
    /**
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1&&triangle.get(0).size() == 1) return triangle.get(0).get(0);
        int row = triangle.size();
        int[] dp = new int[row];
        //dp初始化为最后一行的数字
        for (int i = 0; i < row; i++) dp[i] = triangle.get(row - 1).get(i);
        //倒数第二行开始
        for (int i = row - 2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
