package 回溯.medium._078;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/20
 *     desc   : 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *     说明：解集不能包含重复的子集。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    /**
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *    [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    static List<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> track = new LinkedList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public static void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for(int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
