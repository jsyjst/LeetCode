package medium._091;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/04
 *     desc   : 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *              'A' -> 1
 *              'B' -> 2
 *               ...
 *              'Z' -> 26
 *              给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     * <p>
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     */

    /**
     * 如果当前位为0：
     * 如果前一位不是1或2，则这个0无法和任何数组成字母，代表整个串无法构成编码
     * 如果前一位是1或者2，则说明前一位和当前位能组成字母，这时候能构成的编码数目是和前前位相同的，即：dp[i] = dp[i-2]
     * 如果当前位不为0：
     * 如果前一位和当前位能组成字母，则当前位的构成编码数目应该为前一位和前前位之和，即：dp[i] = dp[i-1] + dp[i-2]，当然要考虑当前位是否符合i>=2?
     * 如果前一位和当前位不能组成字母，则当前位单独组成字母，即dp[i] = dp[i-1]
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == '0') { //如果为0
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') //如果是210或220这种情况
                    dp[i] = i >= 2 ? dp[i - 2] : dp[i - 1];
                else return 0;
            } else {//如果不为0
                if (s.charAt(i - 1) == '1'|| (s.charAt(i) < '7' && s.charAt(i - 1) == '2')) { //如果能和前面组成字母，1 17或1 26这种情况
                    if (i < 2) dp[i] = dp[i - 1] + 1;
                    else dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length() - 1];
    }
}
