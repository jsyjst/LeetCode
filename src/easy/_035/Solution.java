package easy._035;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/26
 *     desc   :给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *            如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *            你可以假设数组中无重复元素。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     *
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     *
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     *
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */

    /**
     * 二分查找
     * @param nums 数组
     * @param target 目标值
     * @return 索引或插入位置
     */
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high = nums.length-1;
        int mid = (low+high)/2;
        //二分查找索引
        while (low<=high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]< target){
                if(low == high) return mid+1;
                low = mid+1;
            }else {
                if(low == high) return mid-1;
                high = mid-1;
            }
        }
        //插入位置情况
        if(nums[mid]>target){
            return mid-1;
        }else{
            return mid+1;
        }
    }
}
