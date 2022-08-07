package 回溯.medium._039;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/28
 *     desc   : 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 *              找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的数字可以无限制重复被选取。
 *
 *              说明：
 *              所有数字（包括 target）都是正整数。
 *              解集不能包含重复的组合。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     * [7],
     * [2,2,3]
     * ]
     * <p>
     * 示例 2:
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     */


    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, sum, i);
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
