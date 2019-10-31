package medium._473;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/31
 *     desc   : 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。
 *     不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。输入为小女孩拥有火柴的数目，每根火柴用其长度表示。
 *     输出即为是否能用所有的火柴拼成正方形。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,1,2,2,2]
     * 输出: true
     * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
     *
     * 输入: [3,3,3,3,4]
     * 输出: false
     * 解释: 不能用所有火柴拼成一个正方形。
     */
    public boolean makesquare(int[] nums) {
        if(nums.length<4) return false;
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%4!=0) return false;
        Arrays.sort(nums);
        return helper(nums,nums.length-1,new int[4],sum/4);
    }

    private boolean helper(int[]nums,int pos,int[] sums,int avg){
        if(pos == -1) return sums[0]==avg&&sums[1]==avg&&sums[2]==avg&&sums[3]==avg;
        for (int i = 0; i < 4; i++) {
            if(nums[pos]+sums[i]>avg) continue;
            sums[i]+=nums[pos];
            if(helper(nums,pos-1,sums,avg)){
                return true;
            }
            sums[i]-=nums[pos];
        }
        return false;
    }
}
