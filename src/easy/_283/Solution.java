package easy._283;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/01
 *     desc   : 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length-1;
        int i=0;
        while (i<len){
            if(nums[i] != 0) {
                i++;
            }else {
                for (int j = i; j < len; j++) {
                    nums[j] = nums[j+1];
                }
                nums[len--] = 0;
            }
        }
    }

    public void moveZeroesBetter(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
