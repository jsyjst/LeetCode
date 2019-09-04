package medium._300;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/04
 *     desc   : 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     */

    //动态规划
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<2) return len;
        int dp[] = new int[len];
        dp[0] = 1;
        int maxI = 1;
        for (int i = 1; i < len; i++) {
            int maxJ = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]) maxJ = Math.max(maxJ,dp[j]);
            }
            dp[i] = maxJ + 1;
            maxI = Math.max(dp[i],maxI);
        }
        return maxI;
    }
}
