package easy._168;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/03
 *     desc   : 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * </pre>
 */
public class Solution {
    /**
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     *
     * 输入: 1
     * 输出: "A"
     *
     * 输入: 28
     * 输出: "AB"
     *
     * 输入: 701
     * 输出: "ZY"
     */
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }
}
