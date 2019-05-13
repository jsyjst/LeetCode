package medium._016;

import java.util.Arrays;
import java.util.Collections;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/13
 *     desc   : 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 *              找出 nums 中的三个整数，使得它们的和与 target 最接近。
 *              返回这三个数的和。假定每组输入只存在唯一答案。
 * </pre>
 */
public class Solution {
    /**
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeNum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {//跳过重复的值
                while (left < right) {
                    int threeNum = nums[i] + nums[right] + nums[left];
                    if (Math.abs(threeNum - target) < Math.abs(closeNum - target)) {
                        closeNum = threeNum;
                    }
                    if (threeNum > target) {
                        while (left < right && nums[right] == nums[right - 1]) right--; //跳过重复的值
                        right--;
                    } else if (threeNum < target) {
                        while (left < right && nums[left] == nums[left + 1]) left++; //跳过重复的值
                        left++;
                    } else {
                        //如果相等就直接返回
                        return threeNum;
                    }
                }
            }
        }
        return closeNum;
    }
}
