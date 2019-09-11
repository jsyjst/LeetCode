package medium._324;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/11
 *     desc   : 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * </pre>
 */
public class Solution {
    /**
     * 输入: nums = [1, 5, 1, 1, 6, 4]
     * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
     *
     * 输入: nums = [1, 3, 2, 2, 3, 1]
     * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
     * 说明:
     * 你可以假设所有输入都会得到有效的结果。
     * 进阶:
     * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
     */
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] bak = Arrays.copyOf(nums, len);
        Arrays.sort(bak);
        int sStart = (len+1)/2;
        int bStart = len - 1;
        sStart--;
        for (int i = 0; i < len / 2; i++) {
            nums[2 * i] = bak[sStart--];
            nums[2 * i + 1] = bak[bStart--];

        }
        // 处理len(small) - len (big)=1;
        if (len % 2 != 0) {
            nums[len - 1] = bak[0];
        }
    }
}
