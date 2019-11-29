package easy._724;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/11/29
 *     desc   :
 * </pre>
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int sum = 0;
        for(int num:nums) sum+=num;
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sumLeft*2+nums[i] == sum) return i;
            sumLeft+=nums[i];
        }
        return -1;
    }
}
