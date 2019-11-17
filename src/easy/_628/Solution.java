package easy._628;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/17
 *     desc   : 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,3]
     * 输出: 6
     * 输入: [1,2,3,4]
     * 输出: 24
     */

    //排序
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length-1;
        return nums[len]*Math.max(nums[len-2]*nums[len-1],nums[0]*nums[1]);
    }

    //线性时间
    public int maximumProductBetter(int[] nums) {
        int min1 = Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2=Integer.MAX_VALUE,max3=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<min1){
                min2=min1;
                min1= num;
            }else if(num<min2){
                min2 = num;
            }
            if(num>max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num>max2){
                max3 = max2;
                max2 = num;
            }else if(num>max3){
                max3 = num;
            }
        }
        return max1*Math.max(max2*max3,min1*min2);
    }
}
