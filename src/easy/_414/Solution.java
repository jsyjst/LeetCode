package easy._414;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/13
 *     desc   : 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [3, 2, 1]
     * 输出: 1
     * 解释: 第三大的数是 1.
     *
     * 输入: [1, 2]
     * 输出: 2
     * 解释: 第三大的数不存在, 所以返回最大的数 2 .
     *
     * 输入: [2, 2, 3, 1]
     * 输出: 1
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * 存在两个值为2的数，它们都排第二。
     */
    public int thirdMax(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int maxFirst = nums[0];//最大的数
        int maxSecond  = Integer.MIN_VALUE;//第二大的数
        int maxThird = Integer.MIN_VALUE;//第三大的数
        boolean isHaveMinValue = false;
        for (int i = 1; i <len ; i++) {
            maxFirst = Math.max(maxFirst,nums[i]);
        }
        for (int num : nums) {
            if (num == maxFirst) continue;
            maxSecond = Math.max(num, maxSecond);
        }
        //如果没有第二大的值，就返回最大致
        if(maxSecond == Integer.MIN_VALUE) return maxFirst;
        for(int num:nums){
            if(num == Integer.MIN_VALUE) isHaveMinValue = true;
            if(num == maxFirst||num == maxSecond) continue;
            maxThird = Math.max(maxThird,num);
        }
        return (maxThird == Integer.MIN_VALUE&&!isHaveMinValue)?maxFirst:maxThird;
    }

    public int thirdMaxBetter(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        long maxFirst = Long.MIN_VALUE;//最大的数
        long maxSecond  = Long.MIN_VALUE;//第二大的数
        long maxThird = Long.MIN_VALUE;//第三大的数
        for (long num : nums) {
            if(num>maxFirst){
                maxThird = maxSecond;
                maxSecond = maxFirst;
                maxFirst = num;
            }else if(num<maxFirst&&num>maxSecond){
                maxThird = maxSecond;
                maxSecond = num;
            }else if(num<maxSecond&&num>maxThird){
                maxThird = num;
            }
        }
        return (maxThird == Long.MIN_VALUE)?(int)maxFirst:(int)maxThird;
    }
}
