package easy._704;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/27
 *     desc   :
 * </pre>
 */
public class Solution {

    /**
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     *
     */

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<=right){
            mid = left+(right-left)/2;
            if(target == nums[mid]) return mid;
            if(target > nums[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
