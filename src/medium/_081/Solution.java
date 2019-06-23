package medium._081;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/23
 *     desc   : 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *              ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *              编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 *
 *            注：这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 *              这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        int[] nums = {1,1,3,1};
        System.out.println(search(nums,3));
    }
    /**
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     *
     * 输入: nums = [2,5,6,0,0,1,2], target = 3
     * 输出: false
     */
    public static boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int left=0;
        int right = nums.length-1;
        int mid;
        while (left<=right){
            mid = left+(right-left)/2;
            if(nums[mid] == target) return true;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }else if(nums[mid]<=nums[right]){
                if(target>nums[mid]&&target<=nums[right]){
                    left = mid+1;
                }else {
                    right = mid - 1;
                }
            }else {
                if(target<nums[mid]&&target>=nums[left]){
                    right = mid - 1;
                }else{
                    left = mid +1;
                }
            }
        }
        return false;
    }
}
