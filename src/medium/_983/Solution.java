package medium._983;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/10
 *     desc   : 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
 *     在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。
 *     每一项是一个从 1 到 365 的整数。
 * 火车票有三种不同的销售方式：
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，
 * 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * </pre>
 */
public class Solution {
    /**
     * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
     * 输出：11
     * 解释：
     * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
     * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
     * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
     * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
     * 你总共花了 $11，并完成了你计划的每一天旅行。
     */
    private int len;
    public int mincostTickets(int[] days, int[] costs) {
        //dp为每一天的花费
        int[] dp = new int[366];
        dp[0] = 0;
        int index = 0;
        for (int i = 1; i < 366; i++) {
            if(index == days.length) break;
            //如果今天不旅行，花费等于前一天的花费
            if(days[index]!=i) {
                dp[i] = dp[i-1];
                continue;
            }
            //今天旅行
            dp[i] = Math.min(
                    dp[Math.max(0,i-1)]+costs[0],
                    Math.min(dp[Math.max(0,i-7)]+costs[1],
                            dp[Math.max(0,i-30)]+costs[2])

            );
            index++;
        }
        return dp[days[days.length-1]];
    }
}
