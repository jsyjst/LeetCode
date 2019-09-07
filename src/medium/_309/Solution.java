package medium._309;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/07
 *     desc   : 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *      设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *      你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *      卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        if(len == 2) return Math.max(0,prices[1]-prices[0]);
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1];
            for (int j = i-1; j >= 0; j--) {
                int diff = prices[i]-prices[j];//卖出
                if(diff<0) continue;//利润小于0
                if(j>=2){
                    dp[i] = Math.max(dp[i],dp[j-2]+diff);
                }else {
                    dp[i] = Math.max(dp[i],diff);
                }
            }
        }
        return dp[len-1];
    }
}
