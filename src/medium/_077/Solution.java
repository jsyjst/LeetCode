package medium._077;

import java.util.ArrayList;
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
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),n,k,1);
        return res;
    }

    private void backtrack(List<List<Integer>> resList,List<Integer> res,int n,int k,int index){
        if(k == 0){
            resList.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i <= n; i++) {
            res.add(i);
            backtrack(resList, res, n, k-1, i+1);
            res.remove(res.size()-1);
        }
    }
}
