package medium._090;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>());
        if (nums.length == 0) {
            return resList;
        }
        Arrays.sort(nums);
        backtrack(resList, new ArrayList<>(), nums,0);
        return resList;
    }

    private static void backtrack(List<List<Integer>> resList, List<Integer> res, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if(i!=0&&nums[i]==nums[i-1]&&i>start) continue;
            res.add(nums[i]);
            resList.add(new ArrayList<>(res));
            backtrack(resList, res, nums, i + 1);
            res.remove(res.size() - 1);
        }
    }
}

