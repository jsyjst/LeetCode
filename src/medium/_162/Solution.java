package medium._162;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/03
 *     desc   : 峰值元素是指其值大于左右相邻值的元素。
 *     给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *     数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *     你可以假设 nums[-1] = nums[n] = -∞。
 *
 *     说明:你的解法应该是 O(logN) 时间复杂度的。
 * </pre>
 */
public class Solution {
    /**
     * 输入: nums = [1,2,3,1]
     * 输出: 2
     * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
     *
     * 输入: nums = [1,2,1,3,5,6,4]
     * 输出: 1 或 5
     * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
     *      或者返回索引 5， 其峰值元素为 6。
     */

    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right =nums.length-1;
        int mid;
        while (left < right){
            mid = left + (right - left)/2;
            if(left!=mid&&right!=mid&&nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) return mid;
            if(nums[mid]>nums[mid+1]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
