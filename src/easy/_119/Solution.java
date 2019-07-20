package easy._119;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/20
 *     desc   : 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 3
     * 输出: [1,3,3,1]
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) res.add(1);
                else {
                    res.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre.clear();
            pre.addAll(res);
        }
        return res;
    }
}
