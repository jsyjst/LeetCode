package medium._216;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/17
 *     desc   : 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *     说明：所有数字都是正整数。解集不能包含重复的组合。
 * </pre>
 */
public class Solution {
    /**
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * <p>
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),k,n,1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> resList, int k, int n,int start) {
        if(n<0) return;
        if(n==0&&k==0){
            res.add(new ArrayList<>(resList));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if(i>n) return;
            resList.add(i);
            helper(res, resList, k-1, n-i, i+1);
            resList.remove(resList.size()-1);
        }
    }
}
