package medium._456;

import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/27
 *     desc   : 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
 *     设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1, 2, 3, 4]
     * 输出: False
     * 解释: 序列中不存在132模式的子序列
     */
    public boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
            if(min == nums[i]) continue;
            for (int j = nums.length-1; j>i ; j--) {
                if(nums[j]>min&&nums[j]<nums[i]) return true;
            }
        }
        return false;
    }
}
