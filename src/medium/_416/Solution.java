package medium._416;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/14
 *     desc   : 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *     注意:
 *     每个数组中的元素不会超过 100
 *     数组的大小不会超过 200
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1, 5, 11, 5]
     * 输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *
     * 输入: [1, 2, 3, 5]
     * 输出: false
     * 解释: 数组不能分割成两个元素和相等的子集.
     */

    //背包问题,原问题转化为取出一些数，使得这些数的和为整个数组元素和的一半

    //状态转移方程：dp[i][j]=dp[i-1][j]|dp[i-1][j-num[i]]
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<2) return false;
        int sum = 0;
        for(int num:nums){
            sum +=num;
        }
        //如果为奇数则返回false
        if(sum%2!=0) return false;
        int target = sum/2;
        boolean[][] dp = new boolean[n][target+1];
        for (int i = 1; i < target+1; i++) {
            if(nums[0] == i) dp[0][i] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < target+1; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i]) dp[i][j] = dp[i-1][j]|dp[i-1][j-nums[i]];
            }
        }
        return dp[n-1][target];
    }


    //优化
    public boolean canPartitionBetter(int[] nums) {
        int n = nums.length;
        if(n<2) return false;
        int sum = 0;
        for(int num:nums){
            sum +=num;
        }
        //如果为奇数则返回false
        if(sum%2!=0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        for (int i = 1; i < target+1; i++) {
            if(nums[0] == i) {
                dp[i] = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = target; j>=0&&j>=nums[i]; j--) {
                dp[j] = dp[j]|dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
