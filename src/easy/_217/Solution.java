package easy._217;

import java.util.HashSet;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/18
 *     desc   : 给定一个整数数组，判断是否存在重复元素。
 *     如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * 输入: [1,2,3,4]
     * 输出: false
     *
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<2) return false;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        return set.size() != nums.length;
    }
}
