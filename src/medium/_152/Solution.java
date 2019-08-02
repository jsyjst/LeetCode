package medium._152;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/02
 *     desc   : 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            max = Math.max(num,max);
            if(num == 0) continue;
            for (int j = i+1; j < nums.length; j++) {
                num *= nums[j];
                max = Math.max(num,max);
                if(num == 0) break;
            }

        }
        return max;
    }

    //动规
    public int maxProductBest(int[] nums) {
        if(nums.length == 1) return nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = Math.max(nums[i],Math.max(preMax*nums[i],preMin*nums[i]));
            int curMin = Math.min(nums[i],Math.min(preMin*nums[i],preMax*nums[i]));
            res = Math.max(res,curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }


}
