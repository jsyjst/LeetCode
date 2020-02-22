package 动态规划.股票._188;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/22
 *     desc   :
 * </pre>
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length < 1) return 0;
        if(k >= prices.length / 2) return max(prices);

        //第i天，第j次交易，状态：0表示不持有股票，1表示持有股票
        int[][][] dp = new int[prices.length][k+1][2];
        //第一天交易k次持有股票的情况
        for(int i = 1; i < k+1; i++) dp[0][i][1] = -prices[0];

        for(int i = 1; i < prices.length; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[prices.length-1][k][0];

    }

    //不限次交易
    public int max(int[] prices){
        int res = 0;
        //只要盈利就卖出
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i-1])
                res += prices[i] - prices[i-1];
        return res;
    }
}
