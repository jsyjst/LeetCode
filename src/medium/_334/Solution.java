package medium._334;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/16
 *     desc   : 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *     数学表达式如下:
 *     如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 *     使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *     说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,3,4,5]
     * 输出: true
     *
     * 输入: [5,4,3,2,1]
     * 输出: false
     */
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int num:nums){
            if(a>=num){
                a = num;
            }else if(b>=num){
                b = num;
            }else {
                return true;
            }
        }
        return false;
    }
}
