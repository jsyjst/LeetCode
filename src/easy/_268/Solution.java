package easy._268;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/30
 *     desc   : 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [3,0,1]
     * 输出: 2
     *
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     */

    //排序
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0] != 0) return 0;
        if(nums[n-1]!= n) return n;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1]!=1) return nums[i]-1;
        }
        return 1;
    }
    //异或
    //4^4 = 0,4^0=4
    public int missingNumberBetter(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
            res^=i;
        }
        return res;
    }
}
