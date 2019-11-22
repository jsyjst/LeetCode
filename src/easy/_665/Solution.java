package easy._665;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/22
 *     desc   : 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [4,2,3]
     * 输出: True
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     */
    public boolean checkPossibility(int[] nums) {
        if(nums.length == 1) return true;
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]<nums[i]) {
                count++;
                if(i-1>=0&&nums[i-1]>nums[i+1]){
                    nums[i+1] = nums[i];
                }else {
                    nums[i] = nums[i+1];
                }
            }
            if(count==2) return false;
        }
        return true;
    }
}
