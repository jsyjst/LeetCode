package easy._053;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/08
 *     desc   : 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *     子数组 是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * </pre>
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        //记录最大值
        int res = nums[0];
        //记录当前连续的值
        int sub = nums[0];
        for(int i = 1;i < len; i++){
            if(sub < 0) {
                res = Math.max(nums[i],res);
                sub = nums[i];
            }else{
                sub += nums[i];
                res = Math.max(sub,res);
            }
        }
        return res;
    }

    /**
     * 动态规划求解
     */
    public int maxSubArrayByDp(int[] nums) {
        int len = nums.length;
        int pre = nums[0];
        int res = pre;
        for(int i = 1; i < len; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(pre, res);
        }
        return res;
    }
}
