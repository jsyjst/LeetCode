package medium._047;

import java.util.ArrayList;
import java.util.Arrays;
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
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visit = new int[nums.length];
        Arrays.sort(nums);
        backtrack(result,new ArrayList<>(),nums,visit);
        return result;
    }

    private void backtrack(List<List<Integer>> result,List<Integer> permuteUniqueList,int[] nums,int[] visit){
        if(permuteUniqueList.size() == nums.length){
            result.add(new ArrayList<>(permuteUniqueList));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            //没有被i-1访问且num[i]跟num[i-1]相等的情况下可以跳过
            if(i!=0&&nums[i]==nums[i-1]&&visit[i-1]==0) continue;
            if(visit[i] ==1) continue;
            visit[i] =1;
            permuteUniqueList.add(nums[i]);
            backtrack(result,permuteUniqueList,nums,visit);
            visit[i]=0;
            permuteUniqueList.remove(permuteUniqueList.size()-1);
        }
    }
}
