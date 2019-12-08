package easy._053;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/08
 *     desc   :
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
}
