package medium._039;

import java.util.ArrayList;
import java.util.Arrays;
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
     *   [7],
     *   [2,2,3]
     * ]
     *
     * 示例 2:
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */


    /**
     * 回溯法实现
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();//存放解空间
        Arrays.sort(candidates);
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    /**
     * 递归实现
     * @param result 所求解集
     * @param sumList 临时变量存储解
     * @param target 目标值
     */
    public static void backtrack(List<List<Integer>> result,List<Integer> sumList,int[] candidates,int target,int start){
        if(target==0){
            result.add(new ArrayList<>(sumList));//进行初始化sumList
            return;
        }else if(target<0){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(candidates[i]>target) break;
            sumList.add(candidates[i]);
            backtrack(result,sumList,candidates,target-candidates[i],i);//回溯
            sumList.remove(sumList.size()-1);
        }

    }
}
