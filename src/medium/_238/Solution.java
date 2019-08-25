package medium._238;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/25
 *     desc   : 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 *     其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int help = 1;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i] = help;
            help *= nums[i];
        }
        help = 1;
        for (int i = len-1; i >=0; i--) {
            res[i]*=help;
            help *= nums[i];
        }
        return res;
    }
}
