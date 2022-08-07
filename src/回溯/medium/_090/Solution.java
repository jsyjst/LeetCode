package 回溯.medium._090;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/20
 *     desc   : 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *              说明：解集不能包含重复的子集。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [1,2,2]
     * 输出:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(res, track, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res,
                          LinkedList<Integer> track, int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for(int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(res, track, nums, i + 1);
            track.removeLast();
        }
    }
}

