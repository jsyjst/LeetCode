package easy._051;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/02
 *     desc   : 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * </pre>
 */
public class Solution {
    /**
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int result = nums[0];
        int sum ;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            result = Math.max(result,sum);
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(result,sum);
            }
        }
        return result;
    }

    /**
     * 优化时间复杂度
     */
    public int maxSubArrayBest(int[] nums) {
        if(nums.length == 1) return nums[0];
        int result = nums[0];
        int sum = 0;
        for(int num: nums){
            if(sum>0){
                sum += num;
            }else {
                sum = num;
            }
            result = Math.max(sum,result);
        }
      return result;
    }
    /**
     * 动态规划
     * 当前面的总和是负数的,加上去一定会使总和减小,不如从自己重新开始.
     * 例如,[-2,1,-3,4]
     * 1就不需要加前面-2,自己可以重新开始.
     */
    public int maxSubArrayBetter(int[] nums) {
        if(nums.length == 1) return nums[0];
        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i]+dp[i-1],nums[i]);
            result = Math.max(dp[i],result);
        }
        return result;
    }
}
