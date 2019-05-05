package hard._010;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/05
 *     desc   : 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *              '.' 匹配任意单个字符。
 *              '*' 匹配零个或多个前面的元素。
 *              匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 *              说明:
 *              s 可能为空，且只包含从 a-z 的小写字母。
 *              p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * <p>
     * 示例 2:
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
     * <p>
     * 示例 3:
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
     * <p>
     * 示例 4:
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
     * <p>
     * 示例 5:
     * 输入:
     * s = "mississippi"
     * p = "mis*is*p*."
     * 输出: false
     */

    public static void main(String[] args) {
        System.out.println(isMatch("aabaa", "a*ba"));
    }


    public static boolean isMatch(String s, String p) {
        s.ma
        if (p.contains(s)) return true;
        if (!p.contains("*") && !p.contains(".")) return false;
        StringBuilder pBuilder = new StringBuilder();
        boolean[] isMore = new boolean[s.length()];
        if (!p.contains(".") && p.contains("*")) {
            pBuilder.append(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    pBuilder.append(s.charAt(i));
                } else {
                    isMore[pBuilder.lastIndexOf(String.valueOf(s.charAt(i)))] = true;
                }
            }
            StringBuilder resultBuilder = new StringBuilder();
            int offset = 0;
            resultBuilder = resultBuilder.append(pBuilder);
            for (int i = 0; i < pBuilder.length(); i++) {
                if (isMore[i]) {
                    resultBuilder.insert(i + offset + 1, "*");
                    offset++;
                }
            }
            System.out.println(resultBuilder.toString());
            if (p.contains(resultBuilder.toString())) return true;
        }
        return false;
    }


    public boolean isMatchOthers(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] result = new boolean[m + 1][n + 1];
        result[0][0] = true;
        for (int i = 0; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    //这里i j 可以有三种情况转化而来。
                    // 1. s去掉*和*之前字母能够 匹配。也就是*之前字母取0次。
                    // 2.*和*之前字母取一次,匹配s中第i个字母，（用递归 所以从1次开始往后几次也是都可以）
                    // 3.这种情况是& 也就是 一定要匹配s中第i-1 。也是因为*之前字母可以取0次，换句话说如果不能匹配i-1 那么一定不能匹配[i][j]
                    result[i][j] = result[i][j - 2] || ((i > 0) && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) && result[i - 1][j];
                } else {
                    // 把. 当成普通字符一起匹配。这个就比较简单当前位置一样，或者是. 并且[i-1][j-1]也是要匹配
                    result[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && result[i - 1][j - 1];
                }
            }
        return result[m][n];
    }
}
