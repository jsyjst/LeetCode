package easy._581;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/20
 *     desc   :
 * </pre>
 */
public class Solution {
    /**
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int right = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i]<max){
                right = i;
            }else {
                max = nums[i];
            }
        }

        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]>min){
                left = i;
            }else {
                min = nums[i];
            }
        }
        return left==right?0:right-left+1;
    }
}
