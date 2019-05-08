package medium._015;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/08
 *     desc   : 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 *             找出所有满足条件且不重复的三元组。
 *
 *             注意：答案中不可以包含重复的三元组。
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumList = new ArrayList<>();
        //第一重循环固定一个值
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) { //跳过重复的值
                while (left < right) {
                    if (nums[left] + nums[right] == -nums[i]) {
                        threeSumList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left<right&&nums[left] == nums[left+1]) left++;  //跳过重复的值
                        while (left<right&&nums[right] == nums[right-1]) right--;//跳过重复的值
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < -nums[i]) {
                        while (left<right&&nums[left] == nums[left+1]) left++; //跳过重复的值
                        left++;
                    } else {
                        while (left<right&&nums[right] == nums[right-1]) right--;//跳过重复的值
                        right--;
                    }
                }
            }
        }
        return threeSumList;
    }
}
