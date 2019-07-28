package medium._137;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/28
 *     desc   : 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [2,2,3,2]
     * 输出: 3
     *
     * 输入: [0,1,0,1,0,1,99]
     * 输出: 99
     */
    public int singleNumber(int[] nums) {
        if(nums.length < 2) return nums[0];
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length -2; i = i+3) {
            if(nums[i] != nums[i+2]) break;
        }
        return nums[i];
    }
}
