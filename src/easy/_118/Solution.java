package easy._118;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/20
 *     desc   : 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> resRow = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(j == 0 || j == i-1 ) resRow.add(1);
                else{
                    resRow.add(res.get(i-2).get(j-1) + res.get(i-2).get(j));
                }
            }
            res.add(resRow);
        }
        return res;
    }
}
