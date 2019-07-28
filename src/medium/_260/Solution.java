package medium._260;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/28
 *     desc   : 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,1,3,2,5]
     * 输出: [3,5]
     */
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0&&nums[i] != nums[i+1]) res[index++] = nums[i];
            if(i == nums.length -1 && nums[i]!= nums[i-1]) res[index++] = nums[i];
            if(i != 0&&i != nums.length -1&&nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]) res[index++] = nums[i];
            if(index > 1) break;
        }
        return res;
    }
}
