package medium._078;

import javax.swing.*;
import java.util.ArrayList;
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
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>());
        if(nums.length == 0){
            return resList;
        }
        backtrack(resList,new ArrayList<>(),nums,0);
        return resList;
    }
    private static void backtrack(List<List<Integer>> resList, List<Integer> res,int[] nums,int start){
        for (int i = start; i < nums.length; i++) {
            res.add(nums[i]);
            resList.add(new ArrayList<>(res));
            backtrack(resList, res, nums, i+1);
            res.remove(res.size()-1);
        }
    }
}
