package easy._171;

import java.util.Map;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/04
 *     desc   : 给定一个Excel表格中的列名称，返回其相应的列序号。
 * </pre>
 */
public class Solution {
    /**
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     *
     * 输入: "A"
     * 输出: 1
     * 输入: "AB"
     * 输出: 28
     *
     * 输入: "ZY"
     * 输出: 701
     */
    public int titleToNumber(String s) {
        int res = 0;
        int len = s.length()-1;
        for (int i = 0; i <s.length(); i++) {
            res+= (s.charAt(i)-'A'+1)*Math.pow(26,len--);
        }
        return res;
    }
}
