package medium._046;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/29
 *     desc   : 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    /**
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visit = new int[nums.length];//数字是否被访问
        //backtrack(result,new ArrayList<>(),nums);
        backtrackTimeBest(result,new ArrayList<>(),nums,visit);
        return result;
    }

    /**
     * 回溯算法，自己的解法，时间复杂度比较大
     * @param result 结果
     * @param permuteList 排列
     * @param nums 数组
     */
    private static void backtrack(List<List<Integer>> result,List<Integer> permuteList,int[] nums){
        if(permuteList.size() == nums.length){
            result.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(!permuteList.contains(nums[i])){
                permuteList.add(nums[i]);
                backtrack(result,permuteList,nums);
                permuteList.remove(permuteList.size()-1);
            }
        }
    }

    /**
     * 优化时间复杂度
     */
    private static void backtrackTimeBest(List<List<Integer>> result,List<Integer> permuteList,int[] nums,int visit[]){
        if(permuteList.size() == nums.length){
            result.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(visit[i] == 1) continue;
            visit[i] = 1;
            permuteList.add(nums[i]);
            backtrackTimeBest(result, permuteList, nums, visit);
            visit[i] = 0;  //下一次循环恢复未访问的状态
            permuteList.remove(permuteList.size()-1);
        }
    }
}
