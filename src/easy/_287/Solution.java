package easy._287;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/01
 *     desc   : 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *     假设只有一个重复的整数，找出这个重复的数
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,3,4,2,2]
     * 输出: 2
     *
     * 输入: [3,1,3,4,2]
     * 输出: 3
     *
     * 说明：
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     */
    public int findDuplicate(int[] nums) {
        int fast = 0,slow = 0;
        while (true){
            fast = nums[nums[fast]];//快指针
            slow = nums[slow];//慢指针
            if(fast == slow) break;
        }
        int finder = 0;
        while (true){
            finder = nums[finder];
            slow = nums[slow];
            if(finder == slow) break;
        }
        return slow;
    }

    //二分法
    public int findDuplicateBinarySearch(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<right){
            mid= left +(right-left)/2;
            int count = 0;
            for(int num:nums){
                if(num<=mid) count++;
            }
            if(count<=mid){
                left = mid +1;
            }else {
                right = mid;
            }
        }
        return left;
    }

}
