package medium._322;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/10
 *     desc   : 给定不同面额的硬币 coins 和一个总金额 amount。
 *     编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 *     如果没有任何一种硬币组合能组成总金额，返回 -1。
 * </pre>
 */
public class Solution {
    /**
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     *
     * 输入: coins = [2], amount = 3
     * 输出: -1
     *
     * 说明:
     * 你可以认为每种硬币的数量是无限的。
     */

    //暴力的动态规划
    public int coinChangeViolent(int[] coins, int amount) {
        if(amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //金额不可达
            if(amount - coins[i]<0) continue;
            int sub = coinChangeViolent(coins,amount-coins[i]);
            if(sub == -1) continue;
            res = Math.min(res,sub+1);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }


    //带备忘录的递归
    public int coinChangeByRecursion(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        return helper(coins,amount,memo);
    }

    private int helper(int[] coins,int amount,int[] memo){
        if(amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        if(memo[amount]!=0) return memo[amount];
        for (int i = 0; i < coins.length; i++) {
            //金额不可达
            if(amount - coins[i]<0) continue;
            int sub = helper(coins,amount-coins[i],memo);
            if(sub == -1) continue;
            res = Math.min(res,sub+1);
        }
        memo[amount] = res==Integer.MAX_VALUE?-1:res;
        return memo[amount];
    }

    //动态规划
    public int coinChangeByDp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin>=0&&dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
    }
}
