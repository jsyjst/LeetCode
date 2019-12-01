package easy._747;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/01
 *     desc   :
 * </pre>
 */
public class Solution {

    //两次循环
    public int dominantIndex(int[] nums) {
        int res = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>max) {
                res = i;
                max =nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i!=res&&max<nums[i]*2) return -1;
        }
        return res;
    }

    //一次循环
    public int dominantIndexBetter(int[] nums) {
        if(nums.length == 1) return 0;
        int res = 0;
        int max = 0;
        int max2 = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max) {
                res = i;
                max2 = max;
                max =nums[i];
            }else if(nums[i]>max2){
                max2 = nums[i];
            }
        }
        return max>=max2*2?res:-1;
    }
}
