package 回溯.medium._047;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/29
 *     desc   : 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * </pre>
 */
public class Solution {
    /**
     * 示例:
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, track, nums, visited);
        return res;
    }

    public void backtrack(List<List<Integer>> res,
                          LinkedList<Integer> track, int[] nums, boolean[] visited) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        int preNum = -666;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (nums[i] == preNum) {
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            preNum = nums[i];
            backtrack(res, track, nums, visited);
            visited[i] = false;
            track.removeLast();
        }
    }
}
