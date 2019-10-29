package medium._462;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/29
 *     desc   : 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。
 *     您可以假设数组的长度最多为10000。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * [1,2,3]
     * 输出:
     * 2
     * 说明：
     * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     */
    public int minMoves2(int[] nums) {
        int len = nums.length;
        if(len<=1) return 0;
        Arrays.sort(nums);
        //找出中位数
        int mid = len%2==0?(nums[(len-1)/2]+nums[len/2])/2:nums[len/2];
        int res = 0;
        for(int num:nums){
            res+=Math.abs(num-mid);
        }
        return res;


    }
}
