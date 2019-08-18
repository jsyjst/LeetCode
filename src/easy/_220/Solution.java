package easy._220;

import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/18
 *     desc   : 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 *     使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * </pre>
 */
public class Solution {
    /**
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     *
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     *
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(t - nums[i])
        }
    }
}
