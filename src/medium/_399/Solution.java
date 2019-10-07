package medium._399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/07
 *     desc   : 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。
 *     如果结果不存在，则返回 -1.0。
 * </pre>
 */
public class Solution {
    /**
     * 示例 :
     * 给定 a / b = 2.0, b / c = 3.0
     * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
     * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
     *
     * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
     * values(方程式结果) = [2.0, 3.0],
     * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<List<String>,Double> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            if(!map.containsKey(equations.get(i))) {
                map.put(equations.get(i),values[i]);
                List<String> temp = new ArrayList<>();
                for (int j = 1; j >=0; j--) {
                    List<String> same = new ArrayList<>();
                    temp.add(equations.get(i).get(j));
                    same.add(equations.get(i).get(j));
                    same.add(equations.get(i).get(j));
                    if(!map.containsKey(same)) map.put(same,1.0);
                }
                map.put(temp,1/values[i]);
            }

        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = map.getOrDefault(queries.get(i),-1.0);
        }
        return res;
    }
}
