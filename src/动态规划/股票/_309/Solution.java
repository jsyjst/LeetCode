package 动态规划.股票._309;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/23
 *     desc   : 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * </pre>
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int dp_0 = 0;
        int dp_1 = -prices[0];
        int dp_2 = 0;
        for(int i = 1; i < len; i++){
            int temp = dp_0;
            dp_0 = Math.max(dp_0,dp_1 + prices[i]);
            dp_1 = Math.max(dp_1,dp_2 - prices[i]);
            dp_2 = temp;
        }
        return dp_0;
    }
}
