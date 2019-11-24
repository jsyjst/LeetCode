package easy._674;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/24
 *     desc   : 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,3,5,4,7]
     * 输出: 3
     * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
     */

    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int right = 0;
        int res = -1;
        for (; right < nums.length-1; right++) {
            if(nums[right]>=nums[right+1]){
                res = Math.max(res,right-left+1);
                left = right+1;
            }
        }
        if(left != right) res = Math.max(res,right-left+1);
        return res==-1?nums.length:res;
    }
}
