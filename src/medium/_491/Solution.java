package medium._491;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/05
 *     desc   : 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        dfs(res,new ArrayList<>(),nums,0);
        return new ArrayList<>(res);
    }

    //深搜，回溯
    private void dfs(Set<List<Integer>> res,List<Integer> sub,int[] nums,int start){
        if(sub.size()>=2) res.add(new ArrayList<>(sub));
        for (int i = start; i < nums.length; i++) {
            if(sub.size()!=0&&sub.get(sub.size()-1)>nums[i]) continue;
            sub.add(nums[i]);
            dfs(res, sub, nums, i+1);
            sub.remove(sub.size()-1);
        }
    }
}
