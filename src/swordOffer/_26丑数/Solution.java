package swordOffer._26丑数;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/01/11
 *     desc   : 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 *     例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * </pre>
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 1) return index;
        int[] dp = new int[index];
        dp[0] = 1;
        int i2 = 0,i3 = 0, i5 = 0;
        for(int i = 0; i < index-1; i++){
            dp[i+1] = Math.min(dp[i2] * 2,Math.min(dp[i3] * 3,dp[i5] * 5));
            if(dp[i+1] == dp[i2] * 2) i2++;
            if(dp[i+1] == dp[i3] * 3) i3++;
            if(dp[i+1] == dp[i5] * 5) i5++;
        }
        return dp[index - 1];
    }
}
