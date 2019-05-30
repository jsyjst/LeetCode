package medium._034;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/26
 *     desc   : 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *              你的算法时间复杂度必须是 O(log n) 级别。
 *              如果数组中不存在目标值，返回 [-1, -1]。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * <p>
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            //mid = (low + high) / 2;  这句语句有可能造成溢出，比如low跟high都很大，两者相加有可能溢出
            mid = low+(high-low)/2;
            if (nums[mid] == target) {
                low = mid;
                high = mid;
                while (low>0&&nums[low]==nums[low-1]) low--; //寻找开始的位置
                while (high<nums.length-1&&nums[high]==nums[high+1]) high++; //寻找结束的位置
                result[0] = low;
                result[1] = high;
                return result;
            }else if(nums[mid]<target){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return result;
    }
}
