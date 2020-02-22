package 动态规划.股票._123;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/22
 *     desc   : 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *     设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *     注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * </pre>
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        int res = 0;
        for(int i = 1; i < len;i++){
            res = Math.max(res,max(prices,0,i) + max(prices,i,len-1));
        }
        return res;
    }

    //区间【start,end】进行一笔交易的最大值
    public int max(int[] prices,int start,int end){
        int max = 0;
        int min = prices[start];
        for(int i = start; i <= end;i++){
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
