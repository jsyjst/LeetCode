package medium._040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/28
 *     desc   : 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的每个数字在每个组合中只能使用一次。
 *              说明：所有数字（包括目标数）都是正整数。
 *              解集不能包含重复的组合。
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
       int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates,8));
    }
    /**
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     *
     * 示例 2:
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result,List<Integer> sumList,int[] candidates,int target,int start){
        if(target<0) return;
        if(target == 0){
            //去重
            if(!result.contains(new ArrayList<>(sumList))){
                result.add(new ArrayList<>(sumList));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(candidates[i]> target) break;
            sumList.add(candidates[i]);
            backtrack(result,sumList,candidates,target - candidates[i],i+1);//i+1保证一个数只用一次
            sumList.remove(sumList.size()-1);
        }
    }

}
