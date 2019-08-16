package medium._209;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/16
 *     desc   : 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 *     如果不存在符合条件的连续子数组，返回 0。
 * </pre>
 */
public class Solution {
    /**
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     * <p>
     * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     */
    //暴力，O(n^2)
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=s) return 1;
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    res = Math.min(j - i, res);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    //滑窗算法,O(n)
    public int minSubArrayLenWindow(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        //i：左边界。j:右边界
        int i=0,j=0,sum=0;
        while (j<nums.length){
            if(sum+nums[j] < s){
                sum+=nums[j++];
            }else {
                res = Math.min(res,j-i+1);
                sum-=nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
