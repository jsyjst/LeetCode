package 回溯.medium._077;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/19
 *     desc   : 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * </pre>
 */
public class Solution {
    /**
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(res, track, n, k, 1);
        return res;
    }

    public void backtrack(List<List<Integer>> res,
                          LinkedList<Integer> track, int n, int k, int start) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = start; i <= n; i++) {
            track.add(i);
            backtrack(res, track, n, k, i + 1);
            track.removeLast();
        }
    }
}
