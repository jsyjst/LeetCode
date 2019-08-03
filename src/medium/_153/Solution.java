package medium._153;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/03
 *     desc   : 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *     ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。请找出其中最小的元素。
 *     你可以假设数组中不存在重复元素。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [3,4,5,1,2]
     * 输出: 1
     *
     * 输入: [4,5,6,7,0,1,2]
     * 输出: 0
     */
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length -1;
        int mid ;
        while (left<right){
            mid = left+(right-left)/2;
            if(mid!=right&&mid!=left&&nums[mid]<nums[mid+1]&&nums[mid]<nums[mid-1]) return nums[mid];
            if(nums[mid]<nums[right]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return nums[left];
    }
}
