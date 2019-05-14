package medium._018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/14
 *     desc   : 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 *             判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 *            找出所有满足条件且不重复的四元组。
 *
 *            注意：答案中不可以包含重复的四元组。
 * </pre>
 */
public class Solution {
    /**
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            //跳过重复值
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i+1; j < nums.length - 2; j++) {
                //跳过重复值
                if (j-1 != i && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;//跳过重复值
                        while (left < right && nums[right] == nums[right - 1]) right--;//跳过重复值
                        left++;
                        right--;
                    }else if(nums[i] + nums[j] + nums[left] + nums[right] < target){
                        while (left < right && nums[left] == nums[left + 1]) left++;//跳过重复值
                        left++;
                    }else if(nums[i] + nums[j] + nums[left] + nums[right] > target){
                        while (left < right && nums[right] == nums[right - 1]) right--;//跳过重复值
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
