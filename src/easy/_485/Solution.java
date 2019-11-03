package easy._485;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/03
 *     desc   : 给定一个二进制数组， 计算其中最大连续1的个数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0) return 0;
        int res = 0;
        int count = 0;
        for(int num:nums){
            if(num == 1){
                count++;
            }else {
                res = Math.max(res,count);
                count = 0;
            }
        }
        return Math.max(res,count);
    }
}
