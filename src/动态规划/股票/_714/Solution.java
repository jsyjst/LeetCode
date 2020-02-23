package 动态规划.股票._714;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/23
 *     desc   :
 *     给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *     你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *     返回获得利润的最大值。
 * </pre>
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if(len < 2) return 0;
        int dp_0 = 0;
        int dp_1 = - prices[0] - fee;
        for(int i = 1; i < len; i++){
            int temp = dp_0;
            dp_0 = Math.max(dp_0,dp_1 + prices[i]);
            dp_1 = Math.max(dp_1,temp - prices[i] - fee);
        }
        return dp_0;
    }
}
