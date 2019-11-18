package easy._643;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/18
 *     desc   : 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,12,-5,-6,50,3], k = 4
     * 输出: 12.75
     * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum= Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < k; i++) {
            pre += nums[i];
        }
        sum = Math.max(sum,pre);
        for (int i = k; i < nums.length; i++) {
            pre = pre-nums[i-k]+nums[i];
            sum = Math.max(sum,pre);
        }
        return (double) sum/k;

    }
}
