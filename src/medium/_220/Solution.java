package medium._220;

import java.util.TreeSet;

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
     * <p>
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     * <p>
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     */

    //滑动窗口,超时
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                if (Math.abs((long) nums[j] - (long) nums[i]) <= t) return true;
            }
        }
        return false;
    }

    //二叉搜索树
    public boolean containsNearbyAlmostDuplicateByTree(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();  //二叉搜索树
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long)nums[i]);
            Long floor = set.floor((long)nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t) return true;
            if (floor != null && nums[i] - floor <= t) return true;
            set.add((long)nums[i]);
            System.out.println(set.size());
            if(set.size()>k) set.remove((long)nums[i-k]);
        }
        return false;
    }
}
