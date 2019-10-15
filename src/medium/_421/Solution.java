package medium._421;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/15
 *     desc   : 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *     找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *     你能在O(n)的时间解决这个问题吗？
 * </pre>
 */
public class Solution {
    /**
     * 输入: [3, 10, 5, 25, 2, 8]
     * 输出: 28
     * 解释: 最大的结果是 5 ^ 25 = 28.
     */
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                res = Math.max(nums[i]^nums[j],res);
            }
        }
        return res;
    }
}
