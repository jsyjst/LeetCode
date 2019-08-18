package easy._219;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/18
 *     desc   : 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 *     使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * </pre>
 */
public class Solution {

    /**
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     *
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     *
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
