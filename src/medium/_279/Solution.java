package medium._279;

import java.util.LinkedList;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/31
 *     desc   : 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * </pre>
 */
public class Solution {
    /**
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     *
     *  输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     */

    //动态规划
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//最坏结果
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    //图论，广度遍历
    class Node{
        private int val;//结点
        private int step;//步数
        Node(int val,int step){
            this.val = val;
            this.step = step;
        }
    }
    public int numSquaresDiagram(int n) {
        LinkedList<Node> queue = new LinkedList<>();//图的广度遍历，队列少不了
        boolean[] visited = new  boolean[n+1];//记录少不了
        queue.offer(new Node(n,0));
        while (!queue.isEmpty()){
            int val = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();
            for (int i = 1; i*i <= val; i++) {
                int k = val - i*i;
                if(k == 0) return step+1;
                if(!visited[k]){
                    queue.offer(new Node(k,step+1));
                    visited[k] = true;
                }
            }
        }
        return -1;
    }
}
