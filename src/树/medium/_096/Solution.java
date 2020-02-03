package 树.medium._096;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/03
 *     desc   : 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * </pre>
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
